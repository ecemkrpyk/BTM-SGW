package com.argelastaj.springbootweblogicbtm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication @EnableScheduling
public class SpringBootWebLogicBtmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebLogicBtmApplication.class, args);
    }

}
