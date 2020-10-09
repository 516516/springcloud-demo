package com.springcloud.personal.system.springclouddemoeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcloudDemoEurekaserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemoEurekaserviceApplication.class, args);
    }

}