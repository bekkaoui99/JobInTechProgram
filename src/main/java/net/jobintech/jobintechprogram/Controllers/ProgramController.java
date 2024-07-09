package net.jobintech.jobintechprogram.Controllers;

import net.jobintech.jobintechprogram.Services.IProgramService;
import net.jobintech.jobintechprogram.dtos.request.ProgramRequest;
import net.jobintech.jobintechprogram.dtos.response.ProgramResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/programs")
public class ProgramController {

    private final IProgramService programService;

    public ProgramController(IProgramService programService) {
        this.programService = programService;
    }


    @PostMapping
    public ProgramResponse create(@RequestBody ProgramRequest programRequest){
        return this.programService.create(programRequest);
    }

    @PostMapping("/addCandidate")
    public ProgramResponse create(@RequestBody Map<String , String> request){
        String candidateId = request.get("candidateId");
        String programTitle = request.get("programTitle");
        return this.programService.addCandidateToProgram(candidateId , programTitle);
    }

    @PutMapping("/{id}")
    public ProgramResponse update(@PathVariable String id , @RequestBody ProgramRequest programRequest){
        return this.programService.update(programRequest ,id);
    }

    @DeleteMapping("/{id}")
    public ProgramResponse delete(@PathVariable String id){
        return this.programService.delete(id);
    }


    @GetMapping("/list")
    public List<ProgramResponse> getActivities(){
        return this.programService.getAll();
    }

    @GetMapping("/page")
    public Page<ProgramResponse> getActivities(
            @RequestParam(name = "pageNumber" , defaultValue = "0") int pageNumber ,
            @RequestParam(name = "pageSize" , defaultValue = "5") int pageSize
    ){
        return this.programService.getAll(pageNumber , pageSize);
    }

}
