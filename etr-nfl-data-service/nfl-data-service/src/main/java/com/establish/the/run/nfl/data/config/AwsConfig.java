package com.establish.the.run.nfl.data.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3Configuration;

import java.net.URI;
import java.time.Duration;

@Configuration @RequiredArgsConstructor
public class AwsConfig {

    private final AwsProperties s3ConfigProperties;

    @Value("${aws.access-key}")
    private String awsAccessKey;

    @Value("${aws.secret-key}")
    private String awsSecretKey;

/*    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.dynamodb-endpoint}")
    private String awsDynamoDbUrl;*/

/*    @Value("${aws.s3.endpoint}")
    private String awsS3Url;*/

    @Bean
    public DynamoDbEnhancedAsyncClient getDynamoDbEnhancedAsyncClient() {
        return DynamoDbEnhancedAsyncClient.builder().dynamoDbClient(getDynamoDbAsyncClient()).build();
    }

    @Bean
    public DynamoDbAsyncClient getDynamoDbAsyncClient() {
        return DynamoDbAsyncClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(awsAccessKey, awsSecretKey)))
                .region(Region.US_EAST_1)
                .build();
    }

/*
    @Bean
    public S3AsyncClient s3AsyncClient(AwsCredentialsProvider awsCredentialsProvider) {

        return S3AsyncClient.builder()
                .httpClient(sdkAsyncHttpClient())
                .region(Region.of(s3ConfigProperties.getRegion()))
                .credentialsProvider(awsCredentialsProvider)
                .endpointOverride(URI.create(s3ConfigProperties.getEndpoint()))
                .forcePathStyle(true)
                .serviceConfiguration(s3Configuration()).build();
    }

    private SdkAsyncHttpClient sdkAsyncHttpClient() {
        return NettyNioAsyncHttpClient.builder()
                .writeTimeout(Duration.ZERO)
                .maxConcurrency(64)
                .build();
    }

    private S3Configuration s3Configuration() {
        return S3Configuration.builder()
                .checksumValidationEnabled(false)
                .chunkedEncodingEnabled(true)
                .build();
    }

    @Bean
    AwsCredentialsProvider awsCredentialsProvider() {
        return () -> AwsBasicCredentials.create(s3ConfigProperties.getAccessKey(), s3ConfigProperties.getSecretKey());
    }
*/

}