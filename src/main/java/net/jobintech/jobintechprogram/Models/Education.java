package net.jobintech.jobintechprogram.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Education {

    private String schooledName;

    private String diploma;

    private String city;

    private Date startedAt;

    private Date endedAt;
}
