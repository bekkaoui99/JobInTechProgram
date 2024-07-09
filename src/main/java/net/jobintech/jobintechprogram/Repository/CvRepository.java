package net.jobintech.jobintechprogram.Repository;


import net.jobintech.jobintechprogram.Models.Cv;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends MongoRepository<Cv,String> {
    Cv findByCandidateId(String candidateId);
}
