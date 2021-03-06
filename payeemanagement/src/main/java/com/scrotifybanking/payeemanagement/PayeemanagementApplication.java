package com.scrotifybanking.payeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type Payeemanagement application.
 */
@SpringBootApplication
@EnableJpaRepositories
public class PayeemanagementApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PayeemanagementApplication.class, args);
    }

}
