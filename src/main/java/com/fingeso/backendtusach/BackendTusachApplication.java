package com.fingeso.backendtusach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableJpaRepositories(basePackages = "com.fingeso.backendtusach.repositories")
@SpringBootApplication
@RestController // Prueba de backend
public class BackendTusachApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTusachApplication.class, args);
	}


// Metodo de prueba
	@GetMapping(path = "/")
	public List<String> getNames(){
		return List.of(
				"Angel",
				"Aracely",
				"Byron",
				"John",
				"Orlando"
		);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}
