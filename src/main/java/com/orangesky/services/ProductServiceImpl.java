package com.orangesky.services;

import com.mongodb.client.MongoCollection;
import com.orangesky.configurations.ProductDetailsConfiguration;
import com.orangesky.dao.ProductDetails;
import com.orangesky.dao.ProductPrice;
import com.orangesky.dao.internal.ProductTitle;
import com.orangesky.services.database.MongoService;
import com.orangesky.services.internal.ProductDetailsService;
import org.bson.Document;
import org.glassfish.jersey.client.JerseyClient;

/**
 * @author RaminderSingh
 */
public class ProductServiceImpl implements IProductService {
    private final JerseyClient httpClient;
    private final ProductDetailsConfiguration productDetailsConfiguration;
    private final MongoCollection<Document> productsCollection;

    public ProductServiceImpl(JerseyClient httpClient, ProductDetailsConfiguration productDetailsConfiguration, MongoCollection<Document> productsCollection) {
        this.httpClient = httpClient;
        this.productDetailsConfiguration = productDetailsConfiguration;
        this.productsCollection = productsCollection;
    }

    public ProductDetails fetchProductDetails(Integer productId) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(productId);
        ProductTitle productTitle = fetchProductTitle(productId);
        productDetails.setTitle(productTitle.getTitle());
        fetchProductTitle(productId);
        productDetails.setPriceDetails(fetchProductPrice(productId));
        return productDetails;
    }

    private ProductTitle fetchProductTitle(Integer productId){
        ProductDetailsService productDetailsService = new ProductDetailsService(httpClient,productDetailsConfiguration);
        return productDetailsService.fetchData(productId);

    }

    private  ProductPrice fetchProductPrice(Integer productId){

        Document document = MongoService.findOneId(productsCollection, productId);

        if (document != null){
            Integer id = document.getInteger("_id");
            String price = document.getString("price");
            String currency = document.getString("currency");
            return new ProductPrice(id,Double.parseDouble(price),currency);


        }
        return null;

    }
}
