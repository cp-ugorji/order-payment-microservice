package com.technologies.stealth.paymentservice.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentServiceApplication {

    //http://localhost:9192/h2-console the h2 console in-memory db endpoint for this service
    //to login, ensure 
    //saved setting and setting name is Generic H2(Embedded)
    //Driver class is org.h2.Driver
    //JDBC Url is jdbc:h2:mem:testdb if you are using memory
    //User Name is sa
    //Password is empty or left blank
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

}
