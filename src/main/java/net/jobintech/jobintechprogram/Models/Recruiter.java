package net.jobintech.jobintechprogram.Models;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Recruiter extends User {
    private String companyName;
}
