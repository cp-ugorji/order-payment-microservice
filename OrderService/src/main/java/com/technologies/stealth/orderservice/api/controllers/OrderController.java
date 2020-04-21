/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologies.stealth.orderservice.api.controllers;

import com.technologies.stealth.orderservice.api.models.OrderRequest;
import com.technologies.stealth.orderservice.api.models.OrderResponse;
import com.technologies.stealth.orderservice.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chukwudiugorji
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService _orderService;
    
    @Autowired
    public OrderController(OrderService orderService){
        this._orderService = orderService;
    }
    
    @PostMapping("/bookorder")
    public OrderResponse bookOrder(@RequestBody OrderRequest request){
        return _orderService.makeOrder(request);
    }
}
