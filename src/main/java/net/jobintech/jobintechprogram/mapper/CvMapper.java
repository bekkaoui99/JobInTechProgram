package net.jobintech.jobintechprogram.mapper;

import net.jobintech.jobintechprogram.Models.Cv;
import net.jobintech.jobintechprogram.dtos.request.CvRequest;
import net.jobintech.jobintechprogram.dtos.response.CvResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CvMapper extends DtoMapperImpl<Cv, CvRequest, CvResponse>{

    public CvMapper(ModelMapper modelMapper) {
        super(modelMapper, Cv.class, CvResponse.class);
    }
}
