package net.jobintech.jobintechprogram.init;

import net.jobintech.jobintechprogram.Services.ICandidateService;
import net.jobintech.jobintechprogram.Services.IRecruiterService;
import net.jobintech.jobintechprogram.dtos.request.CandidateRequest;
import net.jobintech.jobintechprogram.dtos.request.RecruiterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class createData {


//    @Bean
    public CommandLineRunner commandLineRunner(
            IRecruiterService recruiterService,
            ICandidateService CandidateService
            ){
        return args -> {

            RecruiterRequest recruiterRequest = new RecruiterRequest();
            recruiterRequest.setCin("12345");
            recruiterRequest.setEmail("hamza12345@gmail.com");
            recruiterRequest.setPassword("hamza");
            recruiterRequest.setConfirmationPassword("hamza");
            recruiterRequest.setCompanyName("COMPANY1");
            recruiterService.create(recruiterRequest);

            CandidateRequest candidateRequest = new CandidateRequest();
            candidateRequest.setCin("54321");
            candidateRequest.setEmail("hamza54321@gmail.com");
            candidateRequest.setPassword("hamza");
            candidateRequest.setConfirmationPassword("hamza");
            CandidateService.create(candidateRequest);

        };
    }


}
