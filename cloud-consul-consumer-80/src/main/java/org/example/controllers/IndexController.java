package org.example.controllers;

import org.example.servers.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class IndexController {

    @Resource
    private EchoService echoService;

    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable("msg") String msg){
        return echoService.echo(msg);
    }
}
