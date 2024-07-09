package net.jobintech.jobintechprogram.Services.Impl;


import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.blob.models.BlobHttpHeaders;
import net.jobintech.jobintechprogram.Services.IFileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileStorageServiceImpl implements IFileStorageService {

    private final BlobClientBuilder blobClientBuilder;

    public FileStorageServiceImpl(BlobClientBuilder blobClientBuilder) {
        this.blobClientBuilder = blobClientBuilder;
    }

    public String uploadFile(MultipartFile file) {
        String filename = file.getOriginalFilename();
        BlobClient blobClient = blobClientBuilder
                .blobName(filename)
                .buildClient();
        BlobHttpHeaders headers = new BlobHttpHeaders().setContentType(file.getContentType());

        try {
            blobClient.upload(file.getInputStream(), file.getSize(), true);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }

        blobClient.setHttpHeaders(headers);

        return blobClient.getBlobUrl();
    }

    @Override
    public Set<String> uploadFile(Set<MultipartFile> files) {
        Set<String> filesUrl = new HashSet<>();
        for (MultipartFile file : files){
            String uploadedFile = uploadFile(file);
            filesUrl.add(uploadedFile);
        }
        return filesUrl;
    }

    public String updateFile(String blobFileUrl, MultipartFile file) {
        String blobName = extractBlobNameFromUrl(blobFileUrl);
        BlobClient blobClient = blobClientBuilder
                .blobName(blobName)
                .buildClient();
        BlobHttpHeaders headers = new BlobHttpHeaders().setContentType(file.getContentType());

        // Upload will overwrite existing blob if true
        try {
            blobClient.upload(file.getInputStream(), file.getSize(), true);
        } catch (Exception e) {
            throw new RuntimeException("file updated failed");
        }

        blobClient.setHttpHeaders(headers);

        return blobClient.getBlobUrl();
    }

    @Override
    public Set<String> updateFile(Set<String> blobFilesUrl, Set<MultipartFile> files) {
        Set<String> imagesUrl = new HashSet<>();
        for (String fileUrl : blobFilesUrl){
            deleteFile(fileUrl);
        }
        for (MultipartFile file : files){
            String uploadedFile = uploadFile(file);
            imagesUrl.add(uploadedFile);
        }
        return imagesUrl;
    }

    public InputStream downloadFile(String blobFileUrl) {
        String blobName = extractBlobNameFromUrl(blobFileUrl);
        BlobClient blobClient = blobClientBuilder
                .blobName(blobName)
                .buildClient();
        return blobClient.openInputStream();
    }

    public InputStream downloadFilesAsZip(Set<String> blobFilesUrl) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {
            for (String blobFileUrl : blobFilesUrl) {
                try {
                    InputStream inputStream = downloadFile(blobFileUrl);
                    String blobName = extractBlobNameFromUrl(blobFileUrl);
                    zipOutputStream.putNextEntry(new ZipEntry(blobName));
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer)) > 0) {
                        zipOutputStream.write(buffer, 0, len);
                    }
                    inputStream.close();
                    zipOutputStream.closeEntry();
                } catch (Exception ex) {
                    // Log the error and continue with the next file
                    System.err.println("Failed to download or add file to zip: " + blobFileUrl);
                    throw new RuntimeException("Failed to download or add file to zip");
                }
            }
        } catch (Exception e) {
            // Log the error
            System.err.println("Failed to create zip file");
            throw new RuntimeException("Failed to create zip file");
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }


    public void deleteFile(String blobFileUrl) {
        String blobName = extractBlobNameFromUrl(blobFileUrl);
        BlobClient blobClient = blobClientBuilder
                .blobName(blobName)
                .buildClient();
        blobClient.delete();
    }

    @Override
    public void deleteFile(Set<String> blobFilesUrl) {
        for (String fileName : blobFilesUrl){
            deleteFile(fileName);
        }
    }

    private String extractBlobNameFromUrl(String blobFileUrl) {
        // Assuming the URL format is like: https://<account>.blob.core.windows.net/<container>/<blobName>
        return blobFileUrl.substring(blobFileUrl.lastIndexOf('/') + 1);
    }
}
