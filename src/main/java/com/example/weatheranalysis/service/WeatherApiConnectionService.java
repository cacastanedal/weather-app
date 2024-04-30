package com.example.weatheranalysis.service;

import com.example.weatheranalysis.model.ApplicationUsage;
import com.example.weatheranalysis.model.DynamoApplicationUsage;
import com.example.weatheranalysis.repository.ApplicationUsageRepository;
import com.example.weatheranalysis.repository.DynamoApplicationUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherApiConnectionService {

  private final RestTemplate restTemplate = new RestTemplate();

  private final ApplicationUsageRepository applicationUsageRepository;

  private final DynamoApplicationUsageRepository dynamoApplicationUsageRepository;

  private String WEATHER_API_URL = "https://api.weatherapi.com/v1/current.json?key={key}&q={q}";
  private String API_KEY = "f8b15f4fc0cc4175a32220337241804";

  public Object getCurrentWeather(String query){
    Map<String, String> parameters = buildGetParameters(query);

    try{

      ResponseEntity<Object> response = restTemplate.getForEntity(WEATHER_API_URL, Object.class, parameters);

      if(response.getStatusCode() == HttpStatus.OK){

        ApplicationUsage applicationUsage = new ApplicationUsage();
        applicationUsage.setCurrentTime(LocalDateTime.now());
        applicationUsage.setQueryUsed(query);

        applicationUsageRepository.save(applicationUsage);

        DynamoApplicationUsage dynamoApplicationUsage = new DynamoApplicationUsage();
        dynamoApplicationUsage.setCurrentTime(LocalDateTime.now().toString());
        dynamoApplicationUsage.setQueryUsed(query);

        dynamoApplicationUsageRepository.save(dynamoApplicationUsage);
      }

      return response.getBody();

    } catch (RestClientException e){
      return e.getMessage();
    }

  }

  private Map<String, String> buildGetParameters(String query){
    return Map.of(
      "key", API_KEY,
      "q", query
    );
  }
}
