package net.jobintech.jobintechprogram.Services.Impl;


import net.jobintech.jobintechprogram.Models.Recruiter;
import net.jobintech.jobintechprogram.Repository.RecruiterRepository;
import net.jobintech.jobintechprogram.Services.IFileStorageService;
import net.jobintech.jobintechprogram.Services.IRecruiterService;
import net.jobintech.jobintechprogram.dtos.request.RecruiterRequest;
import net.jobintech.jobintechprogram.dtos.response.RecruiterResponse;
import net.jobintech.jobintechprogram.exceptions.ResourceNotFoundException;
import net.jobintech.jobintechprogram.mapper.IDaoMapper;
import net.jobintech.jobintechprogram.security.service.IAuthenticationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class RecruiterServiceImpl implements IRecruiterService {

    private final IAuthenticationService authenticationService;
    private final RecruiterRepository recruiterRepository;
    private final IDaoMapper<Recruiter, RecruiterRequest, RecruiterResponse> recruiterMapper;
    private final IFileStorageService fileStorageService;

    public RecruiterServiceImpl(IAuthenticationService authenticationService, RecruiterRepository recruiterRepository, IDaoMapper<Recruiter, RecruiterRequest, RecruiterResponse> recruiterMapper, IFileStorageService fileStorageService) {
        this.authenticationService = authenticationService;
        this.recruiterRepository = recruiterRepository;
        this.recruiterMapper = recruiterMapper;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public RecruiterResponse create(RecruiterRequest recruiterRequest) {
        return this.authenticationService.recruiterRegistration(recruiterRequest);
    }

    @Override
    public RecruiterResponse update(RecruiterRequest recruiterRequest, String s) {
        return null;
    }

    @Override
    public RecruiterResponse delete(String id) {
        Recruiter recruiterById = this.findRecruiterById(id);
        this.fileStorageService.deleteFile(recruiterById.getImageUrl());
        this.recruiterRepository.delete(recruiterById);
        return this.recruiterMapper.entityToResponse(recruiterById);
    }

    @Override
    public RecruiterResponse getOne(String id) {
        Recruiter recruiterById = this.findRecruiterById(id);
        return this.recruiterMapper.entityToResponse(recruiterById);
    }

    @Override
    public List<RecruiterResponse> getAll() {
        return this.recruiterRepository.findAll()
                .stream()
                .map(recruiterMapper::entityToResponse)
                .toList();
    }

    @Override
    public Page<RecruiterResponse> getAll(int pageNumber, int pageSize) {
        Page<Recruiter> recruiterPage = this.recruiterRepository.findAll(PageRequest.of(pageNumber, pageSize));
        List<RecruiterResponse> recruiterResponseList = recruiterPage.getContent()
                .stream()
                .map(recruiterMapper::entityToResponse)
                .toList();

        return new PageImpl<>(recruiterResponseList , recruiterPage.getPageable() , recruiterPage.getTotalElements());
    }

    private Recruiter findRecruiterById(String id){
        return this.recruiterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate doesn't exist with this ID : " + id));

    }
}

