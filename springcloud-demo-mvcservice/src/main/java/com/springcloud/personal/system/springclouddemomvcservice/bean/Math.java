package com.springcloud.personal.system.springclouddemomvcservice.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * math
 * @author 
 */
@Data
public class Math implements Serializable {
    private Long id;

    /**
     * factor_id
     */
    private Long factorId;

    /**
     * 第一列
     */
    private BigDecimal column1;

    /**
     * 第二列
     */
    private BigDecimal column2;

    /**
     * 第三列
     */
    private BigDecimal column3;

    /**
     * 计算方法code
     */
    private String mathCode;

    /**
     * 计算方法名称
     */
    private String mathName;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    private static final long serialVersionUID = 1L;
}