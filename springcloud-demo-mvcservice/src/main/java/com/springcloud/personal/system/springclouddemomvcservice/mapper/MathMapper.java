package com.springcloud.personal.system.springclouddemomvcservice.mapper;

import com.springcloud.personal.system.springclouddemomvcservice.bean.Math;

public interface MathMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Math record);

    int insertSelective(Math record);

    Math selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Math record);

    int updateByPrimaryKey(Math record);
}