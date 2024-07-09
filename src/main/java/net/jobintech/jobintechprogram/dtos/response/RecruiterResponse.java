package net.jobintech.jobintechprogram.dtos.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RecruiterResponse extends UserResponse{
    private String companyName;
}
