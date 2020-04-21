/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologies.stealth.orderservice.api.models;

import com.technologies.stealth.orderservice.api.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author chukwudiugorji
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Order order;
    private Payment payment;
}
