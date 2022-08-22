package com.beamofsoul.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        System.setProperty("csp.sentinel.app.type", "1"); // gateway mode for sentinel, no web APIs
        SpringApplication.run(GatewayApplication.class, args);
    }
}
