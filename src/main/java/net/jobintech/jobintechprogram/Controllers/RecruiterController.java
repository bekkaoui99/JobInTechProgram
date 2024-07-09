package net.jobintech.jobintechprogram.Controllers;

import net.jobintech.jobintechprogram.Services.IRecruiterService;
import net.jobintech.jobintechprogram.dtos.request.RecruiterRequest;
import net.jobintech.jobintechprogram.dtos.response.RecruiterResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/recruiter")
public class RecruiterController {


    private final IRecruiterService recruiterService;

    public RecruiterController(IRecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }


    @PostMapping
    public RecruiterResponse create(@ModelAttribute RecruiterRequest recruiterRequest){
        return this.recruiterService.create(recruiterRequest);
    }

    @PutMapping("/{id}")
    public RecruiterResponse update(@PathVariable String id , @ModelAttribute RecruiterRequest recruiterRequest){
        return this.recruiterService.update(recruiterRequest ,id);
    }

    @DeleteMapping("/{id}")
    public RecruiterResponse delete(@PathVariable String id){
        return this.recruiterService.delete(id);
    }


    @GetMapping("/list")
    public List<RecruiterResponse> getActivities(){
        return this.recruiterService.getAll();
    }

    @GetMapping("/page")
    public Page<RecruiterResponse> getActivities(
            @RequestParam(name = "pageNumber" , defaultValue = "0") int pageNumber ,
            @RequestParam(name = "pageSize" , defaultValue = "5") int pageSize
    ){
        return this.recruiterService.getAll(pageNumber , pageSize);
    }


}
