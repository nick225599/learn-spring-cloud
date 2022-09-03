package org.example.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.services.EchoService;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class EchoServiceImpl implements EchoService {

    int escapedSecondsNormal = 5;

    @Override
    public String echoPerformance(String msg) {
        return msg;
    }

    @Override
    public String echoNormal(String msg) {
        try {
            TimeUnit.SECONDS.sleep(escapedSecondsNormal);
        } catch (InterruptedException ignored) {
        }
        return msg + ", escaped seconds: " + escapedSecondsNormal;
    }
}
