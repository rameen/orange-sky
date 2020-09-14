package com.orangesky.dao;

/**
 * @author RaminderSingh
 */
public class ProductPrice {
    private float value;
    private String currency;

    public ProductPrice() {
    }

    public ProductPrice(float value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
