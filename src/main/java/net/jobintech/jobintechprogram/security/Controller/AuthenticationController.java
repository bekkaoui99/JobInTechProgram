package net.jobintech.jobintechprogram.security.Controller;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.jobintech.jobintechprogram.dtos.request.AuthenticationRequest;
import net.jobintech.jobintechprogram.dtos.request.CandidateRequest;
import net.jobintech.jobintechprogram.dtos.request.RecruiterRequest;
import net.jobintech.jobintechprogram.dtos.response.AuthenticationResponse;
import net.jobintech.jobintechprogram.dtos.response.CandidateResponse;
import net.jobintech.jobintechprogram.dtos.response.RecruiterResponse;
import net.jobintech.jobintechprogram.security.service.IAuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final IAuthenticationService authenticationService;


    @PostMapping("/login")
    public AuthenticationResponse authentication(@RequestBody AuthenticationRequest authenticationRequest){
       return authenticationService.login(authenticationRequest);
    }

    @PostMapping("/candidateRegistration")
    public ResponseEntity<CandidateResponse> candidateRegistration(@RequestBody CandidateRequest candidateRequest){
        CandidateResponse candidateResponse = authenticationService.CandidateRegistration(candidateRequest);
        return new ResponseEntity<>(candidateResponse , HttpStatus.CREATED);
    }


    @PostMapping("/adminRegistration")
    public ResponseEntity<RecruiterResponse> adminRegistration(@RequestBody RecruiterRequest recruiterRequest){
        RecruiterResponse recruiterResponse = authenticationService.recruiterRegistration(recruiterRequest);
        return new ResponseEntity<>(recruiterResponse , HttpStatus.CREATED);
    }

    @PostMapping("/refreshToken")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    )throws Exception{
        authenticationService.refreshToken(request, response);
    }

}
