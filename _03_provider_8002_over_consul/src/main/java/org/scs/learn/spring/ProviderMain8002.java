package org.scs.learn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8002.class);
    }
}