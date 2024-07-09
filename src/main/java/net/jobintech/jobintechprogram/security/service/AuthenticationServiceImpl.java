package net.jobintech.jobintechprogram.security.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.jobintech.jobintechprogram.Enums.Role;
import net.jobintech.jobintechprogram.Models.Candidate;
import net.jobintech.jobintechprogram.Models.Recruiter;
import net.jobintech.jobintechprogram.Models.User;
import net.jobintech.jobintechprogram.Repository.CandidateRepository;
import net.jobintech.jobintechprogram.Repository.RecruiterRepository;
import net.jobintech.jobintechprogram.Repository.UserRepository;
import net.jobintech.jobintechprogram.Services.IFileStorageService;
import net.jobintech.jobintechprogram.dtos.request.AuthenticationRequest;
import net.jobintech.jobintechprogram.dtos.request.CandidateRequest;
import net.jobintech.jobintechprogram.dtos.request.RecruiterRequest;
import net.jobintech.jobintechprogram.dtos.request.UserRequest;
import net.jobintech.jobintechprogram.dtos.response.AuthenticationResponse;
import net.jobintech.jobintechprogram.dtos.response.CandidateResponse;
import net.jobintech.jobintechprogram.dtos.response.RecruiterResponse;
import net.jobintech.jobintechprogram.exceptions.ResourceNotFoundException;
import net.jobintech.jobintechprogram.mapper.IDaoMapper;
import net.jobintech.jobintechprogram.security.model.SecurityUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {


    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CandidateRepository candidateRepository;
    private final RecruiterRepository recruiterRepository;
    private final JwtService jwtService;
    private final IDaoMapper<Candidate, CandidateRequest, CandidateResponse> candidateMapper;
    private final IDaoMapper<Recruiter, RecruiterRequest, RecruiterResponse> recruiterMapper;
    private final IFileStorageService fileStorageService;

    private void check(UserRequest registrationRequest){
        boolean existsByEmail = userRepository.existsByEmail(registrationRequest.getEmail());
        boolean existsByCin = userRepository.existsByCin(registrationRequest.getCin());
        if(existsByEmail) throw new ResourceNotFoundException("User is already exist with email : " + registrationRequest.getEmail());
        if(existsByCin) throw new ResourceNotFoundException("User is already exist with Cin : " + registrationRequest.getCin());

        if(!registrationRequest.getPassword().equals(registrationRequest.getConfirmationPassword()))
            throw new IllegalArgumentException("confirmation password doesn't match with the password :(");
    }

    @Override
    public CandidateResponse CandidateRegistration(CandidateRequest candidateRequest) {
        this.check(candidateRequest);
        Candidate candidate = candidateMapper.requestToEntity(candidateRequest);
        candidate.setRole(Role.CANDIDATE);
        candidate.setCandidateId(UUID.randomUUID().toString());
        if(candidateRequest.getImageFile() != null){
            String uploadedFile = fileStorageService.uploadFile(candidateRequest.getImageFile());
            candidate.setImageUrl(uploadedFile);

        }
        Candidate createdCandidate = this.candidateRepository.save(candidate);
        return this.candidateMapper.entityToResponse(createdCandidate);
    }

    @Override
    public RecruiterResponse recruiterRegistration(RecruiterRequest recruiterRequest) {
        this.check(recruiterRequest);
        Recruiter recruiter = this.recruiterMapper.requestToEntity(recruiterRequest);
        recruiter.setRole(Role.RECRUITER);
        if(recruiterRequest.getImageFile() != null){
            String uploadedFile = fileStorageService.uploadFile(recruiterRequest.getImageFile());
            recruiter.setImageUrl(uploadedFile);
        }
        Recruiter createdRecruiter = this.recruiterRepository.save(recruiter);
        return this.recruiterMapper.entityToResponse(createdRecruiter);
    }


    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        SecurityUser user = userRepository.findByEmail(authenticationRequest.getEmail())
                .map(SecurityUser::new)
                .orElseThrow(() -> new ResourceNotFoundException("something went wrong"));

        if(user.getPassword().equals(passwordEncoder.encode(authenticationRequest.getPassword())))
            throw new IllegalArgumentException("something went wrong");

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );

        Map<String, Object> claims = new HashMap<>();
        String roles = authenticate.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        claims.put("role", roles);
        String accessToken = jwtService.generateToken(claims, user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .userName(user.getUsername())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }



    public void refreshToken(HttpServletRequest request,
                             HttpServletResponse response
    ) throws Exception {
        final String authHeader = request.getHeader("Authorization");
        final String refreshToken;
        final String username;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);

        username = jwtService.extractUsername(refreshToken);
        if (username != null) {
            var user = this.userRepository.findByEmail(username)
                    .map(SecurityUser::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found :( "));
            if (jwtService.isTokenValid(refreshToken, user)) {
                String newAccessToken = jwtService.generateToken(new HashMap<>(), user);


                var _response = AuthenticationResponse.builder()
                        .userName(user.getUsername())
                        .accessToken(newAccessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper()
                        .writeValue(
                                response.getOutputStream(),
                                _response);
            }
        }
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByEmail = null;
        if(authentication != null && authentication.isAuthenticated()){
            String email = authentication.getName();
            System.out.println("SecurityContextHolder : " + email);
            userByEmail = userRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("user not found with this email : " + email));
        }
        return userByEmail;
    }

}
