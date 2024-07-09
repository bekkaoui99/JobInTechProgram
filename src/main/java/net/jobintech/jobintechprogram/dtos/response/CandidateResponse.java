package net.jobintech.jobintechprogram.dtos.response;

import lombok.*;
import net.jobintech.jobintechprogram.Models.Apply;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CandidateResponse extends UserResponse{

    private String cvUrl;
    private CvResponse cv;
    private Apply apply;
    private ProgramResponse program;
}
