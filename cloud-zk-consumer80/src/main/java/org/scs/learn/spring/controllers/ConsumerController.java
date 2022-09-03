package org.scs.learn.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.scs.learn.spring.clients.ProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    @Resource
    ProviderClient providerClient;

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/echo/{msg}")
    String echo(@PathVariable("msg") String msg){
        String msgFromServer = providerClient.echoPerformance(msg);
//        String msgFromServer = restTemplate.getForObject("http://zk-provider/provider/echo/performance/" + msg, String.class);
        return msgFromServer;
    }
}
