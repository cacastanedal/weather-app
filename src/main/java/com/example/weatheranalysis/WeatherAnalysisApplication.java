package com.example.weatheranalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class WeatherAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherAnalysisApplication.class, args);
	}

}
