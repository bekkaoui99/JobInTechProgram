package net.jobintech.jobintechprogram.Repository;


import net.jobintech.jobintechprogram.Models.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate,String> {

    Optional<Candidate> findByCandidateId(String candidateId);
    Optional<Candidate> findByCin(String cin);

}
