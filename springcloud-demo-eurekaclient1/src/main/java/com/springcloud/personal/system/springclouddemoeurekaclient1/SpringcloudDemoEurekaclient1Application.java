package com.springcloud.personal.system.springclouddemoeurekaclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient//向服务中心注册一个【服务】
@EnableHystrix//开启断路器功能
@EnableHystrixDashboard//断路器监控功能开启
@EnableDiscoveryClient//【@LoadBalanced 负载均衡】 向服务中心注册一个【ribbon】【服务间的调用模式：ribbon+restTemplate】
public class SpringcloudDemoEurekaclient1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemoEurekaclient1Application.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}