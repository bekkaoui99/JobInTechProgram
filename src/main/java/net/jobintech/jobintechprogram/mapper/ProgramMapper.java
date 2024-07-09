package net.jobintech.jobintechprogram.mapper;

import net.jobintech.jobintechprogram.Models.Program;
import net.jobintech.jobintechprogram.dtos.request.ProgramRequest;
import net.jobintech.jobintechprogram.dtos.response.ProgramResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProgramMapper extends DtoMapperImpl<Program, ProgramRequest, ProgramResponse>{

    public ProgramMapper(ModelMapper modelMapper) {
        super(modelMapper, Program.class, ProgramResponse.class);
    }

}
