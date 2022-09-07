package org.scs.learn.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/server")
public class ServerController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/port")
    public String serverPort() {
        return serverPort;
    }
}
