/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologies.stealth.paymentservice.api.controller;

import com.technologies.stealth.paymentservice.api.entities.Payment;
import com.technologies.stealth.paymentservice.api.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chukwudiugorji
 */
@RestController
@RequestMapping("/api/v1/payment")
@Slf4j
public class PaymentController {
    private final PaymentService _paymentService;
    
    @Autowired
    public PaymentController(PaymentService paymentService){
        this._paymentService = paymentService;
    }
    
    @PostMapping("/dopayment")
    public Payment doPayment(@RequestBody Payment payment){
        log.info("Initial Payment Request => " + payment);
        return _paymentService.makePayment(payment);
    }
    
    @GetMapping("/getPaymentByOrder/{orderId}")
    public Payment getPaymentByOrderId(@PathVariable int orderId){
        return _paymentService.getByOrderId(orderId);
    }
}
