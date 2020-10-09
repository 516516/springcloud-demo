package com.springcloud.personal.system.springclouddemoeurekaclient1.controller;

import com.springcloud.personal.system.springclouddemoeurekaclient1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-09 14:18
 **/
@Controller
@RequestMapping("/demo")
public class HelloController {

    @Autowired
    HelloService helloService;

    @ResponseBody
    @PostMapping(value = "query")
    public HashMap<String,Object> getOnePersonById(@RequestParam Long personId){
        HashMap<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","success");
        result.put("data",helloService.getOnePersonById(personId));
        return result;
    }

}