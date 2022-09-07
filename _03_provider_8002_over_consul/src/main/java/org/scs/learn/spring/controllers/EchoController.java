package org.scs.learn.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/echo")
public class EchoController {

    @GetMapping("/{msg}")
    public String echo(@PathVariable("msg") String msg) {
        return msg;
    }
}
