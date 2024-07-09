package net.jobintech.jobintechprogram.Repository;


import net.jobintech.jobintechprogram.Models.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProgramRepository extends MongoRepository<Program, String> {
    Optional<Program> findByTitle(String title);
    List<Program> findAllByYear(String year);
    Page<Program> findAllByYear(String year , Pageable pageable);
    List<Program> findAllByYearAndStartedAtAndEndedAt(String year , Date startedAt , Date endedAt);
    Page<Program> findAllByYearAndStartedAtAndEndedAt(String year , Date startedAt , Date endedAt , Pageable pageable);
}
