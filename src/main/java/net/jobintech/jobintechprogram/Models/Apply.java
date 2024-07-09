package net.jobintech.jobintechprogram.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Apply {

    @Id
    private String id;
    private String programName;
    private String year;
    private Date startedAt;
    private Date endedAt;
    private Set<ApplyProgress> applyProgresses;

    @DBRef
    private Candidate candidate;

}
