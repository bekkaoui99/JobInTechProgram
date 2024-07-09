package net.jobintech.jobintechprogram.mapper;


import net.jobintech.jobintechprogram.Models.User;
import net.jobintech.jobintechprogram.dtos.request.UserRequest;
import net.jobintech.jobintechprogram.dtos.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserMapper extends DtoMapperImpl<User, UserRequest, UserResponse>{

    public UserMapper(ModelMapper modelMapper) {
        super(modelMapper, User.class, UserResponse.class);
    }
}
