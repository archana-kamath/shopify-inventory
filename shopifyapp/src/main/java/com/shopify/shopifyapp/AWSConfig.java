package com.shopify.shopifyapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * @author archa
 * This class creates an AWS s3 bucket object that is required to store the item image
 */
@Configuration
public class AWSConfig {
	
    @Value("${aws.access_key_id}")
    private String accessKeyId;

    @Value("${aws.secret_access_key}")
    private String secretAccessKey;

    @Value("${aws.s3.region}")
    private String region;
    
	    @Bean
	    public AmazonS3 s3() {
	        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId,secretAccessKey);
	        return AmazonS3ClientBuilder
	                .standard()
	                .withRegion("us-west-2")
	                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
	                .build();

	    }
}