package com.orangesky.dao;

/**
 * @author RaminderSingh
 */

public class ProductDetails {
    private Integer id;
    private String title;
    private ProductPrice priceDetails;


    public ProductDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductPrice getPriceDetails() {
        return priceDetails;
    }

    public void setPriceDetails(ProductPrice priceDetails) {
        this.priceDetails = priceDetails;
    }

}
