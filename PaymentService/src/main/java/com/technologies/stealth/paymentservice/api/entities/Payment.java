/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologies.stealth.paymentservice.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "PAYMENT_TB")
public class Payment {
    @Id
    @GeneratedValue
    private int id;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
    
    public Payment(String paymentStatus, String transactionId, int orderId, double amount){
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.amount = amount;
    }
}
