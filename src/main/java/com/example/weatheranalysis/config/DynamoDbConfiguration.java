package com.example.weatheranalysis.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfiguration {

  @Value("${DYNAMO_ACCESS_KEY}")
  private String accessKey;

  @Value("${DYNAMO_SECRET_KEY}")
  private String secretKey;

  @Bean
  public DynamoDBMapper dynamoDBMapper(){
    return new DynamoDBMapper(buildAmazonDynamoDb());
  }

  private AmazonDynamoDB buildAmazonDynamoDb() {
    return AmazonDynamoDBClientBuilder
      .standard()
      .withEndpointConfiguration(
        new AwsClientBuilder.EndpointConfiguration(
          "dynamodb.us-east-1.amazonaws.com",
          "us-east-1"
        )
      )
      .withCredentials(
        new AWSStaticCredentialsProvider(
          new BasicAWSCredentials(
            accessKey,
            secretKey
          )
        )
      )
      .build();
  }
}
