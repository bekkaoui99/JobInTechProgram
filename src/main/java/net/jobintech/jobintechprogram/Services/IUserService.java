package net.jobintech.jobintechprogram.Services;

import net.jobintech.jobintechprogram.Enums.Role;
import net.jobintech.jobintechprogram.dtos.request.RegistrationRequest;
import net.jobintech.jobintechprogram.dtos.response.RegistrationResponse;
import org.springframework.data.domain.Page;
import java.util.List;


public interface IUserService extends CrudService<RegistrationRequest, RegistrationResponse , String>{

    RegistrationResponse findOne(Role role , String id);
    RegistrationResponse findOneByEmail(Role role , String email);
    List<RegistrationResponse> findAll(Role role);
    Page<RegistrationResponse> findAll(Role role , int pageNumber , int pageSize);

}
