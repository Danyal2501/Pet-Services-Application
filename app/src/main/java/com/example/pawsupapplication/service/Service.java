package com.example.pawsupapplication.service;

import java.math.BigDecimal;

/**
 *
 * @author Yunfei Wang
 * Interface representing a service
 *
 */
public interface Service {

    /**
     * Get the id of the service
     * @return the id of the service
     */
    public int getId();

    /**
     * Set the id of the service given an id
     * @param id the id of the service
     */
    public void setId(int id);
    /**
     * Get the user id of the service
     * @return the user id of the service
     */
    public int getUserId();

    /**
     * Set the user id of the service given an id
     * @param id the user id of the service
     */
    public void setUserId(int id);
    /**
     * Get the name of the service
     * @return the name of the service
     */
    public String getName();

    /**
     * Set the name of the service given the name
     * @param name the name of the service
     */
    public void setName(String name);
    /**
     * Get the description of the service
     * @return the description of the service
     */
    public String getDesc();

    /**
     * Set the description of the service
     * @param desc the description of the service
     */
    public void setDesc(String desc);
    /**
     * Get the address of the service
     * @return the address of the service
     */
    public String getAddress();

    /**
     * Set the address of the service
     * @param ads the address of the service
     */
    public void setAddress(String ads);
    /**
     * Get the price of the service
     * @return the price of the service
     */
    public BigDecimal getPrice();

    /**
     * Set the price of the service given a price
     * @param price the price of the service
     */
    public void setPrice(BigDecimal price);

}
