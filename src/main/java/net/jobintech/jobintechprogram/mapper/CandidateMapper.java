package net.jobintech.jobintechprogram.mapper;

import net.jobintech.jobintechprogram.Models.Candidate;
import net.jobintech.jobintechprogram.dtos.request.CandidateRequest;
import net.jobintech.jobintechprogram.dtos.response.CandidateResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CandidateMapper extends DtoMapperImpl<Candidate, CandidateRequest, CandidateResponse>{

    public CandidateMapper(ModelMapper modelMapper ) {
        super(modelMapper, Candidate.class, CandidateResponse.class);
    }
}
