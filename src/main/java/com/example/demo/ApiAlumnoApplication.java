package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la aplicación Spring Boot.
 *
 * <p>Arranca el contexto de Spring (component scanning, auto-configuración, etc.) y expone
 * la API REST definida en el proyecto.</p>
 */
@SpringBootApplication
public class ApiAlumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAlumnoApplication.class, args);
	}

}
