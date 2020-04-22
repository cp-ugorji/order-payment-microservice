package com.technologies.stealth.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    //http://localhost:9193/hystrix/ to access hystrix dashboard.
    //to monitor gateway api for all request and their respective response status, 
    //copy the gateway actuator and hystrix endpoint which is http://localhost:9190/actuator/hystrix.stream
    //and paste it in the textfield provided in the hystrix dashboard.
    //Voila, you will see count of request and as well as if they failed or succeeded
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }

}
