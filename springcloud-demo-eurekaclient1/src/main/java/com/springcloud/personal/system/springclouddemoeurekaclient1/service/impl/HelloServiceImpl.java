package com.springcloud.personal.system.springclouddemoeurekaclient1.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.personal.system.springclouddemoeurekaclient1.bean.Person;
import com.springcloud.personal.system.springclouddemoeurekaclient1.mapper.PersonMapper;
import com.springcloud.personal.system.springclouddemoeurekaclient1.process.RequestBean;
import com.springcloud.personal.system.springclouddemoeurekaclient1.process.RequestMathBean;
import com.springcloud.personal.system.springclouddemoeurekaclient1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-09 14:15
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Value("$(server.post)")
    String port;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Person getOnePersonById(Long id) {
        return personMapper.selectByPrimaryKey(id);
    }

    public String hiError(RequestMathBean bean) {
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
    public String hystrixById(RequestMathBean bean) {

        //json-post
        String str4=restTemplate.postForObject("http://SPRINGCLOUD-DEMO-MVCSERVICE:8080/mvc-service/demo/json",bean,String.class);
        System.out.println(str4);

        return str4;
    }
}
