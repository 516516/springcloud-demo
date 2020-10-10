package com.springcloud.personal.system.springclouddemomvcservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.personal.system.springclouddemomvcservice.bean.Math;
import com.springcloud.personal.system.springclouddemomvcservice.mapper.MathMapper;
import com.springcloud.personal.system.springclouddemomvcservice.process.RequestBean;
import com.springcloud.personal.system.springclouddemomvcservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-09 10:14
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Value("$(server.post)")
    String port;

    @Autowired
    MathMapper mathMapper;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Math getOneById(Long id) {
        return mathMapper.selectByPrimaryKey(id);
    }

    @Override
    public String getFromRestService(Long id) {
        RequestBean reqParam=new RequestBean();
        reqParam.setPersonId(id);

        Map<String,Long>param=new HashMap<>();
        param.put("personId",id);

        //
        String str1=restTemplate.postForObject("http://SPRINGCLOUD-DEMO-EUREKACLIENT1:8081/mvc2-service/demo/query",reqParam,String.class);
        System.out.println(str1);

        //object-post
        String str2=restTemplate.postForObject("http://SPRINGCLOUD-DEMO-EUREKACLIENT1:8081/mvc2-service/demo/object",reqParam,String.class);
        System.out.println(str2);

        //map-post
        String str3=restTemplate.postForObject("http://SPRINGCLOUD-DEMO-EUREKACLIENT1:8081/mvc2-service/demo/map",reqParam,String.class);
        System.out.println(str3);

        //json-post
        String str4=restTemplate.postForObject("http://SPRINGCLOUD-DEMO-EUREKACLIENT1:8081/mvc2-service/demo/json",reqParam,String.class);
        System.out.println(str4);

        //get
        String str5=restTemplate.getForObject("http://SPRINGCLOUD-DEMO-EUREKACLIENT1:8081/mvc2-service/demo/get?personId={personId}",String.class,param);
        System.out.println(str5);

        return str4;
    }

    public String hiError(RequestBean bean) {
        System.out.println("hi，port:"+port+"failed,sorry!!!!");
        return "hi，port:"+port+"failed,sorry!!!!";
    }


    /**
     * 熔断器添加
     * @param bean
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    @Override
    public String hystrixById(RequestBean bean) {

        //json-post
        String str4=restTemplate.postForObject("http://SPRINGCLOUD-DEMO-EUREKACLIENT1:8081/mvc2-service/demo/json",bean,String.class);
        System.out.println(str4);

        return str4;
    }

}