package org.scs.learn.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableDubbo
public class DubboProvider {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DubboProvider.class, args);
        new CountDownLatch(1).await();
    }
}