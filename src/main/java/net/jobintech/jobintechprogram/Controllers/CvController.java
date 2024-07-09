package net.jobintech.jobintechprogram.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cvs")
public class CvController {
//
//    @Autowired
//    private CvServ cvService;
//
//    @PostMapping("/{candidateId}")
//    public ResponseEntity<Cv> createCv(@RequestBody Cv cv,@PathVariable String candidateId) {
//        Cv createdCv = cvService.create(cv,candidateId);
//        return new ResponseEntity(createdCv, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{candidateId}")
//    public ResponseEntity<Cv> getCvByCandidateId(@PathVariable String candidateId) {
//        Optional<Cv> cv = cvService.getById(candidateId);
//        return cv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Cv> updateCv(@PathVariable String id, @RequestBody Cv cv) {
//        Optional<Cv> existingCv = cvService.getById(id);
//        if (existingCv.isPresent()) {
//            cv.setId(existingCv.get().getId());
//            Cv updatedCv = cvService.update(cv);
//            return ResponseEntity.ok(updatedCv);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCv(@PathVariable String id) {
//        cvService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}

