package com.springcloud.personal.system.springclouddemoeurekaclient1.service;

import com.springcloud.personal.system.springclouddemoeurekaclient1.bean.Person;
import com.springcloud.personal.system.springclouddemoeurekaclient1.process.RequestMathBean;

public interface HelloService {
    Person getOnePersonById(Long id);
    public String hystrixById(RequestMathBean bean);
}
