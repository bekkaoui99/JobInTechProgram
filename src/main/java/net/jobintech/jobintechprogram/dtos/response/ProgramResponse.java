package net.jobintech.jobintechprogram.dtos.response;


import lombok.*;
import net.jobintech.jobintechprogram.Models.Candidate;

import java.util.Date;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProgramResponse {

    private String id;
    private String title;
    private String description;
    private String year;
    private Date startedAt;
    private Date endedAt;
    private Set<Candidate> candidates;
}
