package org.example.springcloud.payment.service;

import org.apache.ibatis.annotations.Param;
import org.example.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getBySerialNo(@Param("serialNo") String serialNo);

}
