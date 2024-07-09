package net.jobintech.jobintechprogram.Controllers;

import net.jobintech.jobintechprogram.Services.ICandidateService;
import net.jobintech.jobintechprogram.dtos.request.CandidateRequest;
import net.jobintech.jobintechprogram.dtos.response.CandidateResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/candidate")
public class CandidateController{


    private final ICandidateService candidateService;

    public CandidateController(ICandidateService iCandidateService) {
        this.candidateService = iCandidateService;
    }

    @PostMapping
    public CandidateResponse create(@ModelAttribute CandidateRequest candidateRequest){
        return this.candidateService.create(candidateRequest);
    }

    @PutMapping("/{id}")
    public CandidateResponse update(@PathVariable String id , @ModelAttribute CandidateRequest candidateRequest){
        return this.candidateService.update(candidateRequest ,id);
    }

    @DeleteMapping("/{id}")
    public CandidateResponse delete(@PathVariable String id){
        return this.candidateService.delete(id);
    }

    @GetMapping("/list")
    public List<CandidateResponse> getActivities(){
        return this.candidateService.getAll();
    }

    @GetMapping("/page")
    public Page<CandidateResponse> getActivities(
            @RequestParam(name = "pageNumber" , defaultValue = "0") int pageNumber ,
            @RequestParam(name = "pageSize" , defaultValue = "5") int pageSize
    ){
        return this.candidateService.getAll(pageNumber , pageSize);
    }



}
