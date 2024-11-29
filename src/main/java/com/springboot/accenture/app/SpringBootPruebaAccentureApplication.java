package com.springboot.accenture.app;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPruebaAccentureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPruebaAccentureApplication.class, args);
	}
	
	@Bean
	public GroupedOpenApi customApi() {
		return GroupedOpenApi.builder()
				.group("testing-group")
				.pathsToMatch("/**")
				.build();
	}

}
