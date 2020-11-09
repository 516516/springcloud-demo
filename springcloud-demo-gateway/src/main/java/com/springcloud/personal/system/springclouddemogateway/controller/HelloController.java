package com.springcloud.personal.system.springclouddemogateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-11-09 11:21
 **/
@RestController
@RequestMapping("demo")
public class HelloController {

    @RequestMapping("index")
    public String sayHello(){
        return "hello";
    }


}
