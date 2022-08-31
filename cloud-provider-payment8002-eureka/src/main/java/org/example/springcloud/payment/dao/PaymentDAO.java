package org.example.springcloud.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.springcloud.entities.Payment;

@Mapper
public interface PaymentDAO {
    int create(Payment payment);

    Payment getBySerialNo(@Param("serialNo") String serialNo);
}
