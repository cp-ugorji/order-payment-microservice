/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologies.stealth.orderservice.api.repositories;

import com.technologies.stealth.orderservice.api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chukwudiugorji
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
