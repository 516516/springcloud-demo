package com.springcloud.personal.system.springclouddemomvcservice.controller;

import com.springcloud.personal.system.springclouddemomvcservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @create: 2020-10-09 09:44
 **/
@RestController
@RequestMapping("demo")
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("index")
    public String sayHello(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public HashMap<String,Object> queryMath(HttpServletRequest request){
        HashMap<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","success");
        result.put("data",helloService.getOneById(Long.valueOf(request.getParameter("mathId"))));
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "queryPersonByRestCall",method = RequestMethod.POST)
    public String queryPerson(HttpServletRequest request){
        return helloService.getFromRestService(Long.valueOf(request.getParameter("personId")));
    }


}