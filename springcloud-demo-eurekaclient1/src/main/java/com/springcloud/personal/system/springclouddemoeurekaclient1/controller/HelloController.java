package com.springcloud.personal.system.springclouddemoeurekaclient1.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springcloud.personal.system.springclouddemoeurekaclient1.process.RequestBean;
import com.springcloud.personal.system.springclouddemoeurekaclient1.process.RequestMathBean;
import com.springcloud.personal.system.springclouddemoeurekaclient1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-09 14:18
 **/
@RestController
@RequestMapping("/demo")
public class HelloController {

    @Value("${server.port}")
    String port;

    @Autowired
    HelloService helloService;

    @ResponseBody
    @PostMapping(value = "query")
    public HashMap<String,Object> getOnePersonById(HttpServletRequest request){
        System.out.println("server port:"+port);
        System.out.println(JSON.toJSONString(request.getParameterMap()));
        HashMap<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","success");
        result.put("data",helloService.getOnePersonById(1L));
        return result;
    }

    @ResponseBody
    @PostMapping(value = "queryWithHystrix")
    public HashMap<String,Object> getOneMathById(HttpServletRequest request){
        System.out.println("server port:"+port);
        System.out.println(JSON.toJSONString(request.getParameterMap()));
        RequestMathBean queryBean=new RequestMathBean();
        queryBean.setMathId(Long.valueOf(request.getParameter("mathId")));
        HashMap<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","success");
        result.put("data",helloService.hystrixById(queryBean));
        return result;
    }



    @ResponseBody
    @RequestMapping(value = "/object", method = RequestMethod.POST)
    public HashMap<String,Object> getOnePersonByObject(@RequestBody RequestBean bean){
        System.out.println("object server port:"+port+"  "+JSON.toJSONString(bean));
        HashMap<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","success");
        result.put("data",helloService.getOnePersonById(bean.getPersonId()));
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/map", method = RequestMethod.POST)
    public HashMap<String,Object> getOnePersonByMap(@RequestBody Map<String,Long> bean){
        System.out.println("map server port:"+port+"  "+JSON.toJSONString(bean));
        HashMap<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","success");
        result.put("data",helloService.getOnePersonById(bean.get("personId")));
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public HashMap<String,Object> getOnePersonByJson(@RequestBody JSONObject bean){
        System.out.println("json server port:"+port+"  "+JSON.toJSONString(bean));
        HashMap<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","success");
        result.put("data",helloService.getOnePersonById(bean.getLong("personId")));
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public HashMap<String,Object> getOnePersonByJson(@RequestParam Long personId){
        System.out.println("json server port:"+port+"  "+JSON.toJSONString(personId));
        HashMap<String,Object> result=new HashMap<>();
        result.put("code",1);
        result.put("msg","success");
        result.put("data",helloService.getOnePersonById(personId));
        return result;
    }

}