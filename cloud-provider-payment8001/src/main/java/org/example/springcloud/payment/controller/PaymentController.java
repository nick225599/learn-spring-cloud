package org.example.springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.CommonResultCodeEnum;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info("PaymentController.create, request: {}", payment);
        int i = paymentService.create(payment);
        CommonResult<Payment> result;
        if (1 == i) {
            result = new CommonResult<>(CommonResultCodeEnum.SUCCESS, payment);
        } else {
            result = new CommonResult<>(CommonResultCodeEnum.FAIL);
        }
        log.info("PaymentController.create, response: {}", result);
        return result;
    }

    @GetMapping("/getBySerialNo/{serialNo}")
    public CommonResult<String> getBySerialNo(@PathVariable("serialNo") String serialNo) {
        log.info("PaymentController.getBySerialNo, request: {}", serialNo);
        Payment payment = paymentService.getBySerialNo(serialNo);
        CommonResult<String> result;
        if (null != payment) {
            result = new CommonResult<>(CommonResultCodeEnum.SUCCESS, payment + ", port: " + serverPort);
        } else {
            result = new CommonResult<>(CommonResultCodeEnum.NOT_FOUND);
        }
        log.info("PaymentController.getBySerialNo, response: {}", result);
        return result;
    }

    @GetMapping("/discovery")
    public String discovery() {
        log.info("discoveryClient.order: {}, description: {}", discoveryClient.getOrder(), discoveryClient.description());
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service: {}", service);
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(service);
            for (ServiceInstance serviceInstance : serviceInstances) {
                log.info("service instance id: {}, metadata: {}, scheme: {}, host: {}, port: {}", serviceInstance.getInstanceId(), serviceInstance.getMetadata(), serviceInstance.getScheme(), serviceInstance.getHost(), serviceInstance.getPort());
                log.info("");
            }
            log.info("");
        }
        return serverPort;
    }

}
