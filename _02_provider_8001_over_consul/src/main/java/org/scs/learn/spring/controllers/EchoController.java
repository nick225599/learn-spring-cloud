package org.scs.learn.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EchoController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/temp/echo/{msg}")
    public String echo(@PathVariable("msg") String msg) {
        return msg;
    }

    @GetMapping("/temp/server/port")
    public String serverPort() {
        return serverPort;
    }
}
