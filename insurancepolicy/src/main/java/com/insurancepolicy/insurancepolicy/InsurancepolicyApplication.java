package com.insurancepolicy.insurancepolicy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InsurancepolicyApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsurancepolicyApplication.class, args);
    }

}
