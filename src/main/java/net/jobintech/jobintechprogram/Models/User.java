package net.jobintech.jobintechprogram.Models;

import lombok.*;
import net.jobintech.jobintechprogram.Enums.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public abstract class User {

    @Id
    private String id;

    private String cin;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role; // CANDIDAT or RECRUTEUR

    private Address address;

    private String phone;

    private String imageUrl;

    private Date birthDay;


}
