package net.jobintech.jobintechprogram.Models;


import lombok.*;
import net.jobintech.jobintechprogram.Enums.ApplyValidate;
import net.jobintech.jobintechprogram.Enums.CandidateState;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApplyProgress {

    private CandidateState candidateState;
    private String comment;
    private ApplyValidate applyValidate;

}
