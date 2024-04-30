package com.example.weatheranalysis.repository;

import com.example.weatheranalysis.model.ApplicationUsage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ApplicationUsageRepository extends MongoRepository<ApplicationUsage, String> {
  public List<ApplicationUsage> findByQueryUsed(String queryUsed);
}
