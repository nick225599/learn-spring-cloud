package org.example.springcloud.service.impl;

import org.example.springcloud.dao.PaymentDAO;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;


    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getBySerialNo(String serialNo) {
        return paymentDAO.getBySerialNo(serialNo);
    }
}
