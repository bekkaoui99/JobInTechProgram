package net.jobintech.jobintechprogram.Models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Candidate extends User {

    private String nationality;
    private String candidateId;
    private String cvUrl;
    private Cv cv;

    @DBRef
    private Program program;


}
