package org.example.controlers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/index")
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable("msg") String msg) {
        return msg + ", server port: " + serverPort;
    }

}
