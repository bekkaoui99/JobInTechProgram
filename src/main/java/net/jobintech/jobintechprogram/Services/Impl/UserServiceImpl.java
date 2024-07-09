package net.jobintech.jobintechprogram.Services.Impl;


import net.jobintech.jobintechprogram.Enums.Role;
import net.jobintech.jobintechprogram.Services.IUserService;
import net.jobintech.jobintechprogram.dtos.request.RegistrationRequest;
import net.jobintech.jobintechprogram.dtos.response.RegistrationResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {


    @Override
    public RegistrationResponse create(RegistrationRequest registrationRequest) {
        return null;
    }

    @Override
    public RegistrationResponse update(RegistrationRequest registrationRequest, String id) {
        return null;
    }

    @Override
    public RegistrationResponse delete(String id) {
        return null;
    }

    @Override
    public RegistrationResponse getOne(String id) {
        return null;
    }

    @Override
    public RegistrationResponse findOne(Role role , String id) {
        return null;
    }
    @Override
    public RegistrationResponse findOneByEmail(Role role , String email) {
        return null;
    }

    @Override
    public List<RegistrationResponse> getAll() {
        return List.of();
    }

    @Override
    public Page<RegistrationResponse> getAll(int pageNumber, int pageSize) {
        return null;
    }



    @Override
    public List<RegistrationResponse> findAll(Role role) {
        return List.of();
    }

    @Override
    public Page<RegistrationResponse> findAll(Role role, int pageNumber, int pageSize) {
        return null;
    }
}
