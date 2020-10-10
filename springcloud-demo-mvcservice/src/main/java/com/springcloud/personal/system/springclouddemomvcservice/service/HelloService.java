package com.springcloud.personal.system.springclouddemomvcservice.service;

import com.springcloud.personal.system.springclouddemomvcservice.bean.Math;
import com.springcloud.personal.system.springclouddemomvcservice.process.RequestBean;

public interface HelloService {
    Math getOneById(Long id);

    String getFromRestService(Long id);

    String hystrixById(RequestBean bean);

}
