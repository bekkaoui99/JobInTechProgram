package net.jobintech.jobintechprogram.mapper;

import net.jobintech.jobintechprogram.Models.Recruiter;
import net.jobintech.jobintechprogram.dtos.request.RecruiterRequest;
import net.jobintech.jobintechprogram.dtos.response.RecruiterResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RecruiterMapper extends DtoMapperImpl<Recruiter, RecruiterRequest, RecruiterResponse>{

    public RecruiterMapper(ModelMapper modelMapper) {
        super(modelMapper, Recruiter.class, RecruiterResponse.class);
    }
}
