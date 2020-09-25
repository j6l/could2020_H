package com.jie.could.entity;

import java.io.Serializable;

/**
 * (TOrder)实体类
 *
 * @author makejava
 * @since 2020-07-07 23:05:37
 */
public class TOrder implements Serializable {
    private static final long serialVersionUID = -61132154773910058L;
    
    private Integer id;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 产品id
    */
    private Integer productId;
    /**
    * 数量
    */
    private Integer tCount;
    /**
    * 金额
    */
    private Double money;
    /**
    * 订单状态：0：创建中; 1：已完结
    */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTCount() {
        return tCount;
    }

    public void setTCount(Integer tCount) {
        this.tCount = tCount;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}