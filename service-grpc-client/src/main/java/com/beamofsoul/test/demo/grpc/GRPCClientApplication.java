package com.beamofsoul.test.demo.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GRPCClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GRPCClientApplication.class, args);
    }
}
