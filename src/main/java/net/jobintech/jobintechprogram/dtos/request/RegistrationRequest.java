package net.jobintech.jobintechprogram.dtos.request;


import lombok.*;
import net.jobintech.jobintechprogram.Models.Address;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegistrationRequest {

    private String cin;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String confirmationPassword;

    private Address address;

    private String Phone;

    private MultipartFile image;

    private Date birthDay;

    private String companyName;
}
