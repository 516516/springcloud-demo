package com.springcloud.personal.system.springclouddemomvcservice.service.impl;

import com.springcloud.personal.system.springclouddemomvcservice.mapper.MathMapper;
import com.springcloud.personal.system.springclouddemomvcservice.process.RequestBean;
import com.springcloud.personal.system.springclouddemomvcservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springcloud.personal.system.springclouddemomvcservice.bean.Math;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-09 10:14
 **/
@Service
public class HelloServiceImpl implements HelloService {
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
        RequestBean bean=new RequestBean();
        bean.setPersonId(id);
        return restTemplate.postForObject("http://SPRINGCLOUD-DEMO-EUREKACLIENT1:8081/mvc2-service/demo/query",bean,String.class);
    }
}