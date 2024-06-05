package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = { "com.curso.controller", "com.curso.service" }, exclude = {
		DataSourceAutoConfiguration.class })
public class GestionMedicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionMedicaApplication.class, args);
	}

	@Bean
	public RestTemplate obtenerRestTemplate() {
		return new RestTemplate();
	}
}
