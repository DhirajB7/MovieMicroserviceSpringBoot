package com.dhirajb7.moviecatalogservice;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogServiceApplication {

    @Bean
	@LoadBalanced
    RestTemplate getRestTemplate(RestTemplateBuilder builder){
		return builder
				.setConnectTimeout(Duration.ofMillis(3000))
				.setReadTimeout(Duration.ofMillis(3000))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
