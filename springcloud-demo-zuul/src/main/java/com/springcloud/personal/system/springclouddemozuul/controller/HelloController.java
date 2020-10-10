package com.springcloud.personal.system.springclouddemozuul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-10 17:28
 **/
@RestController
@RequestMapping("/demo")
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public HashMap<String,Object> queryMath(HttpServletRequest request){
        HashMap<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","success");
        result.put("data","hello world !!!!!");
        return result;
    }

}
