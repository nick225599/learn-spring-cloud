package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("PaymentController.create, request: {}", payment);
        int i = paymentService.create(payment);
        log.info("PaymentController.create, i: {}", i);
        log.info("PaymentController.create, id: {}", payment.getId());
        log.info("PaymentController.create, serialNo: {}", payment.getSerialNo());
        log.info("PaymentController.create, serialNo: {}", payment.getSerialNo());

        CommonResult<Payment> result;
        if (i == 1) {
            result = new CommonResult<>(200, "succsss", payment);
        } else {
            result = new CommonResult<>(500, "service error");
        }
        return result;
    }

    @GetMapping("/getBySerialNo/{serialNo}")
    public CommonResult<Payment> getBySerialNo(@PathVariable("serialNo") String serialNo) {
        Payment payment = paymentService.getBySerialNo(serialNo);
        log.info("PaymentController.create, id: {}", payment.getId());
        log.info("PaymentController.create, serialNo: {}", payment.getSerialNo());
        CommonResult<Payment> result;
        if (null != payment) {
            result = new CommonResult<>(200, "succsss", payment);
        } else {
            result = new CommonResult<>(500, "not such data");
        }
        return result;

    }



}
