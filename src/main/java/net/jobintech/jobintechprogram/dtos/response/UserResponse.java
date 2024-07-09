package net.jobintech.jobintechprogram.dtos.response;


import lombok.*;
import net.jobintech.jobintechprogram.Enums.Role;
import net.jobintech.jobintechprogram.Models.Address;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Role role;

    private Address address;

    private String Phone;

    private String imageUrl;

    private Date birthDay;
}
