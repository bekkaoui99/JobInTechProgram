package net.jobintech.jobintechprogram.Repository;

import net.jobintech.jobintechprogram.Models.Apply;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplyRepository extends MongoRepository<Apply, String> {

}
