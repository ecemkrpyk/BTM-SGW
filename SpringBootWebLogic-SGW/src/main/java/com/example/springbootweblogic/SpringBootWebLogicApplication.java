package com.example.springbootweblogic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
public class SpringBootWebLogicApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebLogicApplication.class, args);
    }
}
