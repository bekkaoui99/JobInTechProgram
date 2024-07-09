package net.jobintech.jobintechprogram.Services.Impl;

import net.jobintech.jobintechprogram.Repository.CvRepository;
import net.jobintech.jobintechprogram.Services.ICvService;
import net.jobintech.jobintechprogram.dtos.request.CvRequest;
import net.jobintech.jobintechprogram.dtos.response.CvResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CvServiceImpl implements ICvService {

    private final CvRepository cvRepository;

    public CvServiceImpl(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public CvResponse create(CvRequest cvRequest) {
        return null;
    }

    @Override
    public CvResponse update(CvRequest cvRequest, String s) {
        return null;
    }

    @Override
    public CvResponse delete(String s) {
        return null;
    }

    @Override
    public CvResponse getOne(String s) {
        return null;
    }

    @Override
    public List<CvResponse> getAll() {
        return List.of();
    }

    @Override
    public Page<CvResponse> getAll(int pageNumber, int pageSize) {
        return null;
    }
}
