package com.psawesome.awsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class AwsSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsSpringBootApplication.class, args);
    }

}
