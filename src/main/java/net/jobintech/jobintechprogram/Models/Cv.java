package net.jobintech.jobintechprogram.Models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cv {

    private String profileTitle;

    private String introduction;

    private Date createdAt;

    private Date updatedAt;

    private List<Education> educations;

    private List<Technology> technologies;

    private List<Experience> experiences;

    private List<Language> languages;

    private List<Project> projects;

}
