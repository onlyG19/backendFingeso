package com.fingeso.backendtusach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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




}