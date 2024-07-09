package net.jobintech.jobintechprogram.Repository;


import net.jobintech.jobintechprogram.Models.Technology;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TechnologyRepository extends MongoRepository<Technology,String> {
    Optional<Technology> findByName(String name);
}
