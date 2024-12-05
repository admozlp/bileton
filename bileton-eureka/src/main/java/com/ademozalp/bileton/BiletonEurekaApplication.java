package com.ademozalp.bileton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BiletonEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BiletonEurekaApplication.class, args);
    }
}