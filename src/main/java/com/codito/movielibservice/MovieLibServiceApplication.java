package com.codito.movielibservice;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@EnableAsync
@SpringBootApplication
public class MovieLibServiceApplication {

	@Value("${http.timeout.in.seconds}")
	private Integer timeoutInSeconds;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieLibServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

		Duration duration = Duration.ofSeconds(timeoutInSeconds);
		return restTemplateBuilder
				.setConnectTimeout(duration)
				.setReadTimeout(duration)
				.build();
	}

}
