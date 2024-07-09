package net.jobintech.jobintechprogram.dtos.response;

import lombok.*;
import net.jobintech.jobintechprogram.Models.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvResponse {

    private String id;

    private String profileTitle;

    private String candidateId;

    private String introduction;

    private Date createdAt;

    private Date updatedAt;

    private List<Education> educations;

    private List<Technology> technologies;

    private List<Experience> experiences;

    private List<Language> languages;

    private List<Project> projects;


}
