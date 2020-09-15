package com.orangesky.services;

import com.orangesky.configurations.ProductDetailsConfiguration;
import com.orangesky.dao.ProductDetails;
import com.orangesky.dao.ProductPrice;
import com.orangesky.dao.internal.ProductTitle;
import com.orangesky.services.internal.ProductDetailsService;
import org.glassfish.jersey.client.JerseyClient;

import java.net.URISyntaxException;

/**
 * @author RaminderSingh
 */
public class ProductServiceImpl implements IProductService {
    private final JerseyClient httpClient;
    private final ProductDetailsConfiguration productDetailsConfiguration;

    public ProductServiceImpl(JerseyClient httpClient, ProductDetailsConfiguration productDetailsConfiguration) {

        this.httpClient = httpClient;
        this.productDetailsConfiguration = productDetailsConfiguration;
    }

    public ProductDetails fetchProductDetails(Integer productId) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(productId);
        ProductTitle productTitle = fetchProductTitle(productId);
        productDetails.setTitle(productTitle.getTitle());
        fetchProductTitle(productId);
        productDetails.setPriceDetails(new ProductPrice(1334,"USD"));
        return productDetails;
    }

    private ProductTitle fetchProductTitle(Integer productId){
        ProductDetailsService productDetailsService = new ProductDetailsService(httpClient,productDetailsConfiguration);
        return productDetailsService.fetchData(productId);

    }
}
