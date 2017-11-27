package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SimpleCabClientApplication {

	private static final Logger log = LoggerFactory.getLogger(SimpleCabClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimpleCabClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			List data = restTemplate.getForObject("http://localhost:8080/api/trippermed/40E882BDD06233B5C99288FFED13F6A1,1B96632294C366D4BDF08099BCAA6E39", List.class);
			
			
			Integer data2 = restTemplate.getForObject("http://localhost:8080/api/totaltrips/40E882BDD06233B5C99288FFED13F6A1/2013-12-01", Integer.class);

			log.info("Trips per Medallion: " + data.toString());
			log.info("Total trip for Medallion on given date: " + data2.toString());
		};
	}
}
