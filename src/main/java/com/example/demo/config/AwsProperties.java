package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "aws.s3")
public class AwsProperties {
    private String accessKey;
    private String secretKey;
    private String region;
    private String bucketName;
}
