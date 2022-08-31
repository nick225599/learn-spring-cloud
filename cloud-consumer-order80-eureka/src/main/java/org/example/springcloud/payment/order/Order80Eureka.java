package org.example.springcloud.payment.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Order80Eureka {
    public static void main(String[] args) {
        SpringApplication.run(Order80Eureka.class, args);
    }
}
