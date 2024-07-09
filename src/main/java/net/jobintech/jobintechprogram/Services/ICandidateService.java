package net.jobintech.jobintechprogram.Services;

import net.jobintech.jobintechprogram.dtos.request.CandidateRequest;
import net.jobintech.jobintechprogram.dtos.request.CvRequest;
import net.jobintech.jobintechprogram.dtos.response.CandidateResponse;
import net.jobintech.jobintechprogram.dtos.response.CvResponse;
import org.springframework.web.multipart.MultipartFile;


public interface ICandidateService extends CrudService<CandidateRequest, CandidateResponse,String>{

    CandidateResponse getCandidateBYCandidateId(String candidateId);
    boolean uploadCv(MultipartFile cvFile);
    CvResponse createdCv(CvRequest cvRequest , MultipartFile cvFile);
    CvResponse updateCv(CvRequest cvRequest);
}
