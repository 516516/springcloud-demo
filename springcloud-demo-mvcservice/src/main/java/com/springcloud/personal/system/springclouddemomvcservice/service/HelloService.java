package com.springcloud.personal.system.springclouddemomvcservice.service;
import com.springcloud.personal.system.springclouddemomvcservice.bean.Math;

public interface HelloService {
    Math getOneById(Long id);

    String getFromRestService(Long id);
}
