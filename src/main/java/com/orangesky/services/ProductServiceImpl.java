package com.orangesky.services;

import com.orangesky.dao.ProductDetails;
import com.orangesky.dao.ProductPrice;

/**
 * @author RaminderSingh
 */
public class ProductServiceImpl implements IProductService {
    public ProductDetails fetchProductDetails(Integer productId) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(productId);
        productDetails.setTitle("First Product");
        productDetails.setPriceDetails(new ProductPrice(1334,"USD"));
        return productDetails;
    }
}
