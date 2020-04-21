/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologies.stealth.cloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author chukwudiugorji
 */
@RestController
public class FallbackController {
    @RequestMapping("/orderFallback")
    public Mono<String> orderServiceFallback(){
        return Mono.just("Order service is taking too long to respond or probably down, please try again later");
    }
    
    @RequestMapping("/paymentFallback")
    public Mono<String> paymentServiceFallback(){
        return Mono.just("Payment service is taking too long to respond or probably down, please try again later");
    }
}
