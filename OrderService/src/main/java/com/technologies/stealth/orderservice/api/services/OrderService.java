/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologies.stealth.orderservice.api.services;

import com.technologies.stealth.orderservice.api.entities.Order;
import com.technologies.stealth.orderservice.api.models.OrderRequest;
import com.technologies.stealth.orderservice.api.models.OrderResponse;
import com.technologies.stealth.orderservice.api.models.Payment;
import com.technologies.stealth.orderservice.api.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author chukwudiugorji
 */
@Service
@Slf4j
public class OrderService {
    private final OrderRepository _orderRepository;
    private final RestTemplate _restTemplate;
    
    @Autowired
    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate){
        this._orderRepository = orderRepository;
        this._restTemplate = restTemplate;
    }
    
    public OrderResponse makeOrder(OrderRequest orderRequest){
        log.info("Initial Order Request => " + orderRequest);
        Payment payment = orderRequest.getPayment();
        payment.setOrderId(orderRequest.getOrder().getId());
        payment.setAmount(orderRequest.getOrder().getAmount());
        log.info("Modified Order Request => " + orderRequest);
        log.info("Modified Payment Request => " + orderRequest);
        
        //call payment microservice using rest template
        //we can as well use apache kafka for async benefit
        Payment paymentResponse = _restTemplate.postForObject("http://PAYMENT-SERVICE/api/v1/payment/dopayment", payment, Payment.class);
        
        //check if payment was successful or not
        String message = paymentResponse.getPaymentStatus().equalsIgnoreCase("successful") ? "Payment was successful and order has been made." : "Payment failed thus order has been added to cart";
        String statusCode = paymentResponse.getPaymentStatus().equalsIgnoreCase("successful") ? "00" : "XX";
        
        //get order from the request and save
        //Order order = orderRequest.getOrder();
        Order newOrder = _orderRepository.save(orderRequest.getOrder());
        
        return new OrderResponse(statusCode, message, newOrder, paymentResponse.getTransactionId(), paymentResponse.getAmount());
    }
}
