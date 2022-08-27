package org.example.springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.CommonResultCodeEnum;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

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
    public CommonResult<Payment> getBySerialNo(@PathVariable("serialNo") String serialNo) {
        log.info( "PaymentController.getBySerialNo, serialNo: {}", serialNo);
        Payment payment = paymentService.getBySerialNo(serialNo);
        CommonResult<Payment> result;
        if (null != payment) {
            result = new CommonResult<>(CommonResultCodeEnum.SUCCESS, payment);
        } else {
            result = new CommonResult<>(CommonResultCodeEnum.NOT_FOUND);
        }
        return result;

    }



}
