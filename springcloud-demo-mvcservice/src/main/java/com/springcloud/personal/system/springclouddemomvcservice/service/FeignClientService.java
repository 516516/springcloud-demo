package com.springcloud.personal.system.springclouddemomvcservice.service;

import com.springcloud.personal.system.springclouddemomvcservice.process.RequestBean;
import com.springcloud.personal.system.springclouddemomvcservice.service.impl.FeignClientServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-10 14:24
 **/
@FeignClient(value = "SPRINGCLOUD-DEMO-EUREKACLIENT1:8081/mvc2-service/demo/",fallback = FeignClientServiceHystric.class)
public interface FeignClientService {

    @RequestMapping(value = "/object", method = RequestMethod.POST)
    public HashMap<String,Object> getOnePersonByObject(RequestBean bean);
}
