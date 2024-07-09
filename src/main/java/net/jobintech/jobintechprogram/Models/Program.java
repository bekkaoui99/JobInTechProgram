package net.jobintech.jobintechprogram.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Program {

    @Id
    private String id;
    private String title;
    private String description;
    private String year;
    private Date startedAt;
    private Date endedAt;
    private Set<Candidate> candidates;

}
