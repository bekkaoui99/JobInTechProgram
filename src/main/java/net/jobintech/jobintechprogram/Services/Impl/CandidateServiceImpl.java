package net.jobintech.jobintechprogram.Services.Impl;

import net.jobintech.jobintechprogram.Models.Candidate;
import net.jobintech.jobintechprogram.Models.Cv;
import net.jobintech.jobintechprogram.Models.User;
import net.jobintech.jobintechprogram.Repository.CandidateRepository;
import net.jobintech.jobintechprogram.Services.ICandidateService;
import net.jobintech.jobintechprogram.Services.IFileStorageService;
import net.jobintech.jobintechprogram.dtos.request.CandidateRequest;
import net.jobintech.jobintechprogram.dtos.request.CvRequest;
import net.jobintech.jobintechprogram.dtos.response.CandidateResponse;
import net.jobintech.jobintechprogram.dtos.response.CvResponse;
import net.jobintech.jobintechprogram.exceptions.ResourceNotFoundException;
import net.jobintech.jobintechprogram.mapper.CandidateMapper;
import net.jobintech.jobintechprogram.mapper.IDaoMapper;
import net.jobintech.jobintechprogram.security.service.IAuthenticationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class CandidateServiceImpl implements ICandidateService {

    private final IAuthenticationService authenticationService;
    private final CandidateRepository candidateRepository;
    private final IDaoMapper<Candidate, CandidateRequest, CandidateResponse> candidateMapper;
    private final IDaoMapper<Cv, CvRequest, CvResponse> cvMapper;

    private final IFileStorageService fileStorageService;


    public CandidateServiceImpl(IAuthenticationService authenticationService, CandidateRepository candidateRepository, CandidateMapper candidateMapper, IDaoMapper<Cv, CvRequest, CvResponse> cvMapper, IFileStorageService fileStorageService) {
        this.authenticationService = authenticationService;
        this.candidateRepository = candidateRepository;
        this.candidateMapper = candidateMapper;
        this.cvMapper = cvMapper;
        this.fileStorageService = fileStorageService;
    }


    @Override
    public CandidateResponse create(CandidateRequest candidateRequest) {
        return this.authenticationService.CandidateRegistration(candidateRequest);
    }

    @Override
    public CandidateResponse update(CandidateRequest candidateRequest, String id) {
        Candidate candidateById = this.findCandidateById(id);
        Candidate updatedCandidateFields = this.candidateMapper.updatedEntityFields(candidateRequest, candidateById);
        String updateFile = this.fileStorageService.updateFile(candidateById.getImageUrl(), candidateRequest.getImageFile());
        updatedCandidateFields.setImageUrl(updateFile);
        Candidate updatedCandidate = this.candidateRepository.save(updatedCandidateFields);
        return this.candidateMapper.entityToResponse(updatedCandidate);
    }

    @Override
    public CandidateResponse delete(String id) {
        Candidate candidateById = this.findCandidateById(id);
        this.fileStorageService.deleteFile(candidateById.getImageUrl());
        this.candidateRepository.delete(candidateById);
        return this.candidateMapper.entityToResponse(candidateById);
    }

    @Override
    public CandidateResponse getOne(String id) {
        Candidate candidateById = this.findCandidateById(id);
        return this.candidateMapper.entityToResponse(candidateById);
    }

    @Override
    public List<CandidateResponse> getAll() {
        return this.candidateRepository.findAll()
                .stream()
                .map(candidateMapper::entityToResponse)
                .toList();
    }

    @Override
    public Page<CandidateResponse> getAll(int pageNumber, int pageSize) {
        Page<Candidate> candidatePage = this.candidateRepository.findAll(PageRequest.of(pageNumber, pageSize));
        List<CandidateResponse> candidateResponseList = candidatePage.getContent()
                .stream()
                .map(candidateMapper::entityToResponse)
                .toList();
        return new PageImpl<>(candidateResponseList , candidatePage.getPageable() , candidatePage.getTotalElements());
    }

    private Candidate findCandidateById(String id){
        return this.candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate doesn't exist with this ID : " + id));

    }

    @Override
    public CandidateResponse getCandidateBYCandidateId(String candidateId) {
        Candidate candidate = this.candidateRepository.findByCandidateId(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate doesn't exist with this CandidateID : " + candidateId));

        return this.candidateMapper.entityToResponse(candidate);
    }

    @Override
    public boolean uploadCv(MultipartFile cvFile) {
        User authenticatedUser = this.authenticationService.getAuthenticatedUser();
        Candidate candidate = this.candidateRepository.findByCin(authenticatedUser.getCin()).get();
        String uploadedFile = this.fileStorageService.uploadFile(cvFile);
        candidate.setCvUrl(uploadedFile);
        Candidate updatedCandidate = this.candidateRepository.save(candidate);
        return true;
    }

    @Override
    public CvResponse createdCv(CvRequest cvRequest, MultipartFile cvFile) {
        return null;
    }

    @Override
    public CvResponse updateCv(CvRequest cvRequest) {
        User authenticatedUser = this.authenticationService.getAuthenticatedUser();
        Candidate candidate = this.candidateRepository.findByCin(authenticatedUser.getCin()).get();
        Cv cv = this.cvMapper.requestToEntity(cvRequest);
        cv.setCreatedAt(new Date());
        candidate.setCv(cv);
        Candidate updatedCandidate = this.candidateRepository.save(candidate);
        return this.cvMapper.entityToResponse(updatedCandidate.getCv());
    }
}
