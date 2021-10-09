package com.example.pawsupapplication.service;

import java.math.BigDecimal;

/**
 *
 * @author Yunfei Wang Implementaion of the Service interface
 *
 */
public class ServiceImpl implements Service {

    private int id;
    private int userid;
    private String name;
    private String desc;
    private String ads;
    private BigDecimal price;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;

    }
    @Override
    public int getUserId() {
        return this.userid;
    }

    @Override
    public void setUserId(int id) {
        this.id = userid;

    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }
    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public void setDesc(String name) {
        this.desc = desc;

    }
    @Override
    public String getAddress() {
        return this.ads;
    }

    @Override
    public void setAddress(String ads) {
        this.ads = ads;

    }
    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
