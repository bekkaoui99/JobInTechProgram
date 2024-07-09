package net.jobintech.jobintechprogram.security.service;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.jobintech.jobintechprogram.Models.User;
import net.jobintech.jobintechprogram.dtos.request.AuthenticationRequest;
import net.jobintech.jobintechprogram.dtos.request.CandidateRequest;
import net.jobintech.jobintechprogram.dtos.request.RecruiterRequest;
import net.jobintech.jobintechprogram.dtos.response.AuthenticationResponse;
import net.jobintech.jobintechprogram.dtos.response.CandidateResponse;
import net.jobintech.jobintechprogram.dtos.response.RecruiterResponse;

public interface IAuthenticationService {

    CandidateResponse CandidateRegistration(CandidateRequest candidateRequest);
    RecruiterResponse recruiterRegistration(RecruiterRequest recruiterRequest);
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception;
    User getAuthenticatedUser();
}
