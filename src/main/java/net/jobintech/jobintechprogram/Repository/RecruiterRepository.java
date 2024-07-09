package net.jobintech.jobintechprogram.Repository;

import net.jobintech.jobintechprogram.Models.Recruiter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecruiterRepository extends MongoRepository<Recruiter,String> {
}
