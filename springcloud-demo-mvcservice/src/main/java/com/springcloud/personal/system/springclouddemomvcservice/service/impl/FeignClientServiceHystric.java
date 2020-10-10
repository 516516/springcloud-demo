package com.springcloud.personal.system.springclouddemomvcservice.service.impl;

import com.springcloud.personal.system.springclouddemomvcservice.process.RequestBean;
import com.springcloud.personal.system.springclouddemomvcservice.service.FeignClientService;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-10 14:24
 **/
@Component
public class FeignClientServiceHystric implements FeignClientService {
    @Override
    public HashMap<String, Object> getOnePersonByObject(RequestBean bean) {
        HashMap resultMap=new HashMap();
        resultMap.put("code",1);
        resultMap.put("msg","success");
        resultMap.put("data",null);
        return resultMap;
    }
}