package net.jobintech.jobintechprogram.Controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/image")
public class ImageController {

//    private final ImageServ imageService;
//
//    public ImageController(ImageServ imageService) {
//        this.imageService = imageService;
//    }
//
//    @PostMapping("/upload/{idCandidat}")
//    public ResponseEntity<String> uploadImage(@RequestParam("file")  MultipartFile file,@PathVariable String idCandidat) throws IOException {
//        return new ResponseEntity(imageService.uploadImage(file,idCandidat), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/download/{fileName}")
//    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) throws IOException {
//        return imageService.downloadImage(fileName);
//    }
//
//    @PutMapping("/update/{fileName}")
//    public ResponseEntity<Image> updateImage(@PathVariable String fileName, @RequestBody Image image) {
//        try {
//            Image updatedImage = imageService.update(fileName, image);
//            return ResponseEntity.ok(updatedImage);
//        } catch (NotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/delete/{fileName}")
//    public ResponseEntity<Void> deleteImage(@PathVariable String fileName) {
//        try {
//            imageService.deleteImg(fileName);
//            return ResponseEntity.ok().build();
//        } catch (NotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @GetMapping("/all")
//    public ResponseEntity<List<Image>> getAllImages() {
//        List<Image> images = imageService.getAll();
//        return ResponseEntity.ok(images);
//    }
//    @GetMapping("/download/all")
//    public ResponseEntity<byte[]> downloadAllImages() throws IOException {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        imageService.downloadAllImages(outputStream);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentDispositionFormData("attachment", "all-images.zip");
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(outputStream.toByteArray());
//    }

}
