package com.springcloud.personal.system.springclouddemomvcservice.controller;

import com.springcloud.personal.system.springclouddemomvcservice.process.RequestBean;
import com.springcloud.personal.system.springclouddemomvcservice.service.FeignClientService;
import com.springcloud.personal.system.springclouddemomvcservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    FeignClientService feignClientService;

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

    /**
     * 1. RPC实现：RestTemplate+Ribbon
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryPersonByRestCall",method = RequestMethod.POST)
    public String queryPerson(HttpServletRequest request){
        return helloService.getFromRestService(Long.valueOf(request.getParameter("personId")));
    }

    /**
     * 2. RPC实现：Feign
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryPersonByFeignCall",method = RequestMethod.POST)
    public HashMap<String,Object> queryPersonByFeignCall(HttpServletRequest request){
        Long personId=Long.valueOf(request.getParameter("personId"));
        RequestBean bean=new RequestBean();
        bean.setPersonId(personId);
        return feignClientService.getOnePersonByObject(bean);
    }

    @ResponseBody
    @RequestMapping(value = "queryPersonByHystricCall",method = RequestMethod.GET)
    public String queryPersonByHystricCall(HttpServletRequest request){
        Long personId=Long.valueOf(request.getParameter("personId"));
        RequestBean bean=new RequestBean();
        bean.setPersonId(personId);
        return helloService.hystrixById(bean);
    }

    @Value("${foo}")
    String foo;
    @RequestMapping(value="/hi")
    public String hi(){
        return foo;
    }


}