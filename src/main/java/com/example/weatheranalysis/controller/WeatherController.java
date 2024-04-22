package com.example.weatheranalysis.controller;


import com.example.weatheranalysis.service.WeatherApiConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
public class WeatherController {

  private final WeatherApiConnectionService weatherApiConnectionService;

  @GetMapping()
  public ResponseEntity<Object> getGreatings(){
    return ResponseEntity.ok("Hello world");
  }

  @GetMapping("/current/{query}")
  public ResponseEntity<Object> getCurrentWeather(@PathVariable String query){

    return ResponseEntity.ok(weatherApiConnectionService.getCurrentWeather(query));
  }


}
