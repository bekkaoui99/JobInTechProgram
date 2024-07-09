package net.jobintech.jobintechprogram.dtos.request;


import lombok.*;
import net.jobintech.jobintechprogram.Models.*;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvRequest {

    private String profileTitle;

    private String introduction;

    private List<Education> educations;

    private List<Technology> technologies;

    private List<Experience> experiences;

    private List<Language> languages;

    private List<Project> projects;

}
