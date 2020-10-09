package com.springcloud.personal.system.springclouddemoeurekaclient1.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * person
 * @author 
 */
@Data
public class Person implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private String adreess;

    private static final long serialVersionUID = 1L;
}