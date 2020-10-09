package com.springcloud.personal.system.springclouddemoeurekaclient1.mapper;

import com.springcloud.personal.system.springclouddemoeurekaclient1.bean.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}