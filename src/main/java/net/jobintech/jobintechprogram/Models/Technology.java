package net.jobintech.jobintechprogram.Models;


import lombok.*;
import net.jobintech.jobintechprogram.Enums.TechnologyLevel;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Technology {

    private String name;
    private TechnologyLevel level;

}
