package com.example.hw_spring_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class HwSpringDataApplication {

    public static void main(String[] args) {

        SpringApplication.run(HwSpringDataApplication.class, args);
    }

}
