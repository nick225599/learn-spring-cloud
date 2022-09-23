package org.scs.learn.spring.controllers;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.springcloud.service.EchoService;
import org.example.springcloud.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.dubbo.common.constants.LoadbalanceRules.CONSISTENT_HASH;

@RestController
public class SayHelloController {

    @DubboReference(loadbalance = CONSISTENT_HASH, parameters = "hash.nodes=320")
    private EchoService echoService;

    @DubboReference(loadbalance = CONSISTENT_HASH)
    private HelloService helloService;

    @GetMapping("/say/hello/{name}")
    String sayHello(@PathVariable("name") String name){
        String echo = echoService.echo(name);
        String hello = helloService.sayHello(name);
        return "name: " + name + ", echo: " + echo + ", hello: " + hello;
    }
}
