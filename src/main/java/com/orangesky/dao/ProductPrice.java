package com.orangesky.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author RaminderSingh
 */
public class ProductPrice {
    @JsonIgnore
    private int id;
    private double value;
    private String currency;


    public ProductPrice() {
    }

    public ProductPrice(int id, double value, String currency) {
        this.id = id;
        this.value = value;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
