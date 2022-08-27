package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001/payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("OrderController.create, request: {}" + payment);
        CommonResult result = restTemplate.postForObject(URI.create(PAYMENT_URL + "/create"), payment, CommonResult.class);
        log.info("OrderController.create, response: {}" + result);
        return result;
    }

    @GetMapping("/payment/getBySerialNo/{serialNo}")
    public CommonResult<Payment> getBySerialNo(@PathVariable("serialNo") String serialNo){
        return restTemplate.getForObject(URI.create(PAYMENT_URL + "/getBySerialNo/" + serialNo), CommonResult.class);

    }
}
