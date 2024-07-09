package net.jobintech.jobintechprogram.Controllers;

import net.jobintech.jobintechprogram.Services.IFileStorageService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private final IFileStorageService fileStorageService;

    public FileController(IFileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/download-zip")
    public ResponseEntity<InputStreamResource> downloadFilesAsZip(@RequestBody Set<String> blobFilesUrl) {
        InputStream zipInputStream = fileStorageService.downloadFilesAsZip(blobFilesUrl);
        InputStreamResource resource = new InputStreamResource(zipInputStream);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=images.zip")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

}