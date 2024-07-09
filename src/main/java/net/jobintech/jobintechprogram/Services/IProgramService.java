package net.jobintech.jobintechprogram.Services;


import net.jobintech.jobintechprogram.dtos.request.ProgramRequest;
import net.jobintech.jobintechprogram.dtos.response.ProgramResponse;


public interface IProgramService extends CrudService<ProgramRequest, ProgramResponse, String>{

    ProgramResponse addCandidateToProgram(String candidateId , String programName);
}
