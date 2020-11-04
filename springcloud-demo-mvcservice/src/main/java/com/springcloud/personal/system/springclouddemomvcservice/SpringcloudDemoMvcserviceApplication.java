package com.springcloud.personal.system.springclouddemomvcservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient//向服务中心注册一个【服务】
@EnableDiscoveryClient//【@LoadBalanced 负载均衡】 向服务中心注册一个【ribbon】【服务间的调用模式：ribbon+restTemplate】
@SpringBootApplication//springboot启动配置
@EnableFeignClients//开启Fegin的功能【服务间调用模式：Fegin】
@EnableHystrix//开启断路器功能
@MapperScan("com.springcloud.personal.system.springclouddemomvcservice.mapper")
public class SpringcloudDemoMvcserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemoMvcserviceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}