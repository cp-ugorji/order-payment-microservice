package com.technologies.stealth.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ApiCloudGatewayApplication {

    //http://localhost:9190/actuator/hystrix.stream is the endpoint to access to see the hystrix stream on the gateway
    //you should see something like data:{"type":"ping"}
    //if hystrix and actuator are all fine 
    public static void main(String[] args) {
        SpringApplication.run(ApiCloudGatewayApplication.class, args);
    }

}
