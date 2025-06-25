// S3UploadService.java
package com.example.demo.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3UploadService {

    private final S3Client s3Client;
    
    @Value("${aws.s3.region}")
    private String region;

    @Value("${aws.s3.bucket}")
    private String bucket;

    public S3UploadService(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String upload(MultipartFile file) throws IOException {
        try {
        String key = UUID.randomUUID() + "_" + file.getOriginalFilename();

        s3Client.putObject(PutObjectRequest.builder()
                        .bucket(bucket)
                        .key(key)
                        .contentType(file.getContentType())
                        .build(),
                software.amazon.awssdk.core.sync.RequestBody.fromInputStream(
                        file.getInputStream(),
                        file.getSize()
                ));
        // アップロード成功後にURLを返す
        return "https://" + bucket + ".s3." + region + ".amazonaws.com/" + key;
        } catch(IOException e ) {
            throw new RuntimeException("S3 Upload failed: "+ e.getMessage(), e);
        }
    }
}
