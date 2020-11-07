package com.springcloud.personal.system.springclouddemotrubine;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient//向服务中心注册一个【服务】
@EnableDiscoveryClient//【@LoadBalanced 负载均衡】 向服务中心注册一个【ribbon】【服务间的调用模式：ribbon+restTemplate】
@SpringBootApplication//springboot启动配置
@EnableFeignClients//开启Fegin的功能【服务间调用模式：Fegin】
@EnableHystrix//开启断路器功能
@EnableHystrixDashboard//断路器监控功能开启
@EnableCircuitBreaker
@EnableTurbine
public class SpringcloudDemoTrubineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemoTrubineApplication.class, args);
    }

//    @Bean
//    public ServletRegistrationBean getServlet() {
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/hystrix.stream");
//        registrationBean.setName("HystrixMetricsStreamServlet");
//        return registrationBean;
//    }

}
