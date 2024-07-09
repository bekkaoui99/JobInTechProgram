package net.jobintech.jobintechprogram.Services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public interface IFileStorageService {

    String uploadFile(MultipartFile file);
    Set<String> uploadFile(Set<MultipartFile> files);

    String updateFile(String filename, MultipartFile file);
    Set<String> updateFile(Set<String> filename, Set<MultipartFile> files);

    InputStream downloadFile(String filename);
    InputStream downloadFilesAsZip(Set<String> blobFilesUrl);

    void deleteFile(String filename);
    void deleteFile(Set<String> filename);

}