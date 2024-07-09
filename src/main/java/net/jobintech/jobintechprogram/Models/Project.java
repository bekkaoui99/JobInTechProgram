package net.jobintech.jobintechprogram.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Project {

    private String titre;
    private String description;
    private Set<String> technologies;
    private String githubUrl;
    private Date startedAt;
    private Date endedAt;

}
