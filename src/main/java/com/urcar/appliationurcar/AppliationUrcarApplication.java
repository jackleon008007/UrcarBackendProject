package com.urcar.appliationurcar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition
@SpringBootApplication
@EnableJpaAuditing
public class AppliationUrcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppliationUrcarApplication.class, args);
	}
	@Bean()
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://urcargreenbackend.netlify.app").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
