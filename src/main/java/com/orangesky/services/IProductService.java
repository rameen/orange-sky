package com.orangesky.services;

import com.orangesky.dao.ProductDetails;
import com.orangesky.dao.ProductPriceRequest;

/**
 * @author RaminderSingh
 */
public interface IProductService {
     ProductDetails fetchProductDetails(Integer productId);
     void updatePriceDetails(ProductPriceRequest productPriceRequest);

}
