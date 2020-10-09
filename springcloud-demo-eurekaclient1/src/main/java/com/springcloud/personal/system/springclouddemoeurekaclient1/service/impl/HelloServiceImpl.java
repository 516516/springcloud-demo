package com.springcloud.personal.system.springclouddemoeurekaclient1.service.impl;

import com.springcloud.personal.system.springclouddemoeurekaclient1.bean.Person;
import com.springcloud.personal.system.springclouddemoeurekaclient1.mapper.PersonMapper;
import com.springcloud.personal.system.springclouddemoeurekaclient1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-09 14:15
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public Person getOnePersonById(Long id) {
        return personMapper.selectByPrimaryKey(id);
    }

}
