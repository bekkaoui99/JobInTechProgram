package net.jobintech.jobintechprogram.dtos.response;



import lombok.*;
import net.jobintech.jobintechprogram.Models.Address;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegistrationResponse {

    private String id;

    private String cin;

    private String firstName;

    private String lastName;

    private String email;

    private Address address;

    private String Phone;

    private MultipartFile image;

    private Date birthDay;

    private String companyName;
}
