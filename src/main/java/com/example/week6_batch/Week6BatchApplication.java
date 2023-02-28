package com.example.week6_batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class Week6BatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week6BatchApplication.class, args);
    }

}
