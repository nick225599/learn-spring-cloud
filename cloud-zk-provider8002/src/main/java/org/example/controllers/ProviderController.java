package org.example.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.services.EchoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/provider")
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @Resource
    private EchoService echoService;

    @GetMapping("/echo/performance/{msg}")
    String echoPerformance(@PathVariable("msg") String msg) {
        return echoService.echoPerformance(msg) + ", provider port: " + port;
    }

    @GetMapping("/echo/normal/{msg}")
    String echoNormal(@PathVariable("msg") String msg) {
        return echoService.echoNormal(msg) + ", provider port: " + port;
    }
}
