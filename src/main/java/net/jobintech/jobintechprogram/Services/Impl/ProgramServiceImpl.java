package net.jobintech.jobintechprogram.Services.Impl;

import net.jobintech.jobintechprogram.Models.Candidate;
import net.jobintech.jobintechprogram.Models.Program;
import net.jobintech.jobintechprogram.Repository.CandidateRepository;
import net.jobintech.jobintechprogram.Repository.ProgramRepository;
import net.jobintech.jobintechprogram.Services.IProgramService;
import net.jobintech.jobintechprogram.dtos.request.ProgramRequest;
import net.jobintech.jobintechprogram.dtos.response.ProgramResponse;
import net.jobintech.jobintechprogram.exceptions.ResourceNotFoundException;
import net.jobintech.jobintechprogram.mapper.IDaoMapper;
import org.springframework.stereotype.Service;
import java.util.Set;


@Service
public class ProgramServiceImpl extends CrudServiceImpl<Program , ProgramRequest , ProgramResponse, String> implements IProgramService {

    private final ProgramRepository programRepository;
    private final CandidateRepository candidateRepository;
    private final IDaoMapper<Program , ProgramRequest , ProgramResponse> programMapper;

    public ProgramServiceImpl(ProgramRepository programRepository,
                              IDaoMapper<Program, ProgramRequest, ProgramResponse> mapper, ProgramRepository programRepository1, CandidateRepository candidateRepository, IDaoMapper<Program, ProgramRequest, ProgramResponse> programMapper) {
        super(programRepository, mapper, "Program");
        this.programRepository = programRepository1;
        this.candidateRepository = candidateRepository;
        this.programMapper = programMapper;
    }

    @Override
    public ProgramResponse addCandidateToProgram(String candidateId, String programTitle) {
        Program program = this.programRepository.findByTitle(programTitle)
                .orElseThrow(() -> new ResourceNotFoundException("Program doesn't exist with this name : " + programTitle));
        Candidate candidate = this.candidateRepository.findByCandidateId(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate doesn't exist with this candidateID : " + candidateId));
        Set<Candidate> candidates = program.getCandidates();
        candidates.add(candidate);
        program.setCandidates(candidates);
        Program updatedProgram = this.programRepository.save(program);
        return this.programMapper.entityToResponse(updatedProgram);
    }
}
