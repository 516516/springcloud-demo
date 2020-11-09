package com.springcloud.personal.system.springclouddemogateway;

import com.springcloud.personal.system.springclouddemogateway.factoryfilter.RequestTimeGatewayFilterFactory;
import com.springcloud.personal.system.springclouddemogateway.filter.RequestTimeFilter;
import com.springcloud.personal.system.springclouddemogateway.globalfilter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcloudDemoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemoGatewayApplication.class, args);
    }

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder){
//        return builder.routes().route(p->p
//                .path("/mvc-service/demo/index")
//                .filters(f->f.addRequestHeader("hello","world"))
//                .uri("http://localhost:8080"))
//                .build();
//    }
//
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/mvc-service/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://localhost:8080")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
        // @formatter:on
    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}