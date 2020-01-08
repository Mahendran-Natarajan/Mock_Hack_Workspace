package com.spring.data.rest.datarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DatarestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatarestApplication.class, args);
	}

}
