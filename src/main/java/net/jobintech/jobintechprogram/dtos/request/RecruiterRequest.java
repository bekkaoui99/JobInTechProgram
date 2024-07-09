package net.jobintech.jobintechprogram.dtos.request;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RecruiterRequest extends UserRequest{
    private String companyName;
}
