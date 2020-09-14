package com.orangesky.services;

import com.orangesky.dao.ProductDetails;

/**
 * @author RaminderSingh
 */
public interface IProductService {
     ProductDetails fetchProductDetails(Integer productId);

}
