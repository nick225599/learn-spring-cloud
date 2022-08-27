package org.example.springcloud.payment.order.controller;

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
    @SuppressWarnings("unchecked")
    public CommonResult<Payment> create(Payment payment) {
        log.info("OrderController.create, request: {}" , payment);
        URI url = URI.create(PAYMENT_URL + "/create");
        CommonResult<Payment> result = restTemplate.postForObject(url, payment, CommonResult.class);
        log.info("OrderController.create, response: {}" , result);
        return result;
    }

    @GetMapping("/payment/getBySerialNo/{serialNo}")
    @SuppressWarnings("unchecked")
    public CommonResult<Payment> getBySerialNo(@PathVariable("serialNo") String serialNo) {
        URI uri = URI.create(PAYMENT_URL + "/getBySerialNo/" + serialNo);
        return restTemplate.getForObject(uri, CommonResult.class);

    }
}
