package net.jobintech.jobintechprogram.dtos.request;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProgramRequest {

    private String title;
    private String description;
    private String year;
    private Date startedAt;
    private Date endedAt;

}
