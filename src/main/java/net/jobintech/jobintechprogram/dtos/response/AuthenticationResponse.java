package net.jobintech.jobintechprogram.dtos.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthenticationResponse {

    private String userName;
    private String accessToken;
    private String refreshToken;
}
