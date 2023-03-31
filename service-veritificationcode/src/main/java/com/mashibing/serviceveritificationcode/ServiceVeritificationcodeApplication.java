package com.mashibing.serviceveritificationcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceVeritificationcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVeritificationcodeApplication.class, args);
    }

}
