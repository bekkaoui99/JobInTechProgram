package net.jobintech.jobintechprogram.Repository;


import net.jobintech.jobintechprogram.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByCin(String cin);
    boolean existsByEmail(String email);
    boolean existsByCin(String cin);
}

