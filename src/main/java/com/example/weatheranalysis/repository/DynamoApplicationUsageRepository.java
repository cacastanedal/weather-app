package com.example.weatheranalysis.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.weatheranalysis.model.DynamoApplicationUsage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DynamoApplicationUsageRepository {

  private final DynamoDBMapper dynamoDBMapper;

  public DynamoApplicationUsage save(DynamoApplicationUsage dynamoApplicationUsage){
    dynamoDBMapper.save(dynamoApplicationUsage);
    return dynamoApplicationUsage;
  }
}
