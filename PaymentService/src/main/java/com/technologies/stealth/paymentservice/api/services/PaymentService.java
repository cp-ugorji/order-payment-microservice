/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologies.stealth.paymentservice.api.services;

import com.technologies.stealth.paymentservice.api.entities.Payment;
import com.technologies.stealth.paymentservice.api.repositories.PaymentRepository;
import java.util.Random;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author chukwudiugorji
 */
@Service
@Slf4j
public class PaymentService {
    private final PaymentRepository _paymentRepository;
    
    public PaymentService(PaymentRepository paymentRepository){
        this._paymentRepository = paymentRepository;
    }
    
    public Payment makePayment(Payment payment){
        payment.setPaymentStatus(processPayment());
        payment.setTransactionId(UUID.randomUUID().toString());
        log.info("Payment Request => " + payment);
        return _paymentRepository.save(payment);
    }
    
    private String processPayment(){
        //this should probably be a 3rd party intgration to payment gateways like stripe, paypal, paystack, rave(flutterwave) etc
        return new Random().nextBoolean() ? "successful" : "failed";
    }
}
