package net.jobintech.jobintechprogram.dtos.request;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CandidateRequest extends UserRequest{
    private MultipartFile cvFile;
    private CvRequest cv;

}
