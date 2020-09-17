package com.orangesky.dao;

/**
 * @author RaminderSingh
 */
public class ProductPriceRequest {
    private Integer productId;
    private  float price;
    private String currency;


    public ProductPriceRequest() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductPriceRequest{");
        sb.append("productId=").append(productId);
        sb.append(", price=").append(price);
        sb.append(", currency='").append(currency).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
