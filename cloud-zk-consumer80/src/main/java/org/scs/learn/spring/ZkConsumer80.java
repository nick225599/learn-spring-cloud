package org.scs.learn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZkConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(ZkConsumer80.class, args);
    }
}