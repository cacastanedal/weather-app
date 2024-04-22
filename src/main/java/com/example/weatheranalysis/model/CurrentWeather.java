package com.example.weatheranalysis.model;

import java.time.LocalDateTime;

public class CurrentWeather {
  long id;

  LocalDateTime lastUpdated;

  double temp_c;

  double wind_kph;

  double humidity;

  double cloud;

  double feels_like_c;

  double uv;
}
