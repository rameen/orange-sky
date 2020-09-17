package com.orangesky.services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.orangesky.configurations.ProductDetailsConfiguration;
import com.orangesky.dao.ProductDetails;
import com.orangesky.dao.ProductPrice;
import com.orangesky.dao.ProductPriceRequest;
import com.orangesky.dao.internal.ProductTitle;
import com.orangesky.exceptions.ResourceNotFoundException;
import com.orangesky.services.database.MongoService;
import com.orangesky.services.internal.ProductDetailsService;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.glassfish.jersey.client.JerseyClient;

import static com.mongodb.client.model.Filters.eq;

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
        ProductPrice productPrice = fetchProductPrice(productId);
        if (productPrice !=null){
            productDetails.setPriceDetails(productPrice);
        }else{
            throw new ResourceNotFoundException();
        }
        return productDetails;
    }

    @Override
    public void updatePriceDetails(ProductPriceRequest productPriceRequest) {
        Bson filter = eq("_id",productPriceRequest.getProductId());
        Bson priceUpdateOp = Updates.set("price",String.valueOf(productPriceRequest.getPrice()));
        Bson currencyUpdateOp = Updates.set("currency",productPriceRequest.getCurrency());
        UpdateResult updateResult = productsCollection.updateOne(filter, Updates.combine(priceUpdateOp, currencyUpdateOp));
        if ( updateResult.getMatchedCount() == 0 ){
            throw new ResourceNotFoundException();
        }


    }

    private ProductTitle fetchProductTitle(Integer productId){
        ProductDetailsService productDetailsService = new ProductDetailsService(httpClient,productDetailsConfiguration);
        return productDetailsService.fetchData(productId);

    }

    private  ProductPrice fetchProductPrice(Integer productId){

        //Document document = MongoService.findOneId(productsCollection, productId);
        Document document = productsCollection.find(eq("_id", productId)).first();

        if (document != null){
            Integer id = document.getInteger("_id");
            String price = document.getString("price");
            String currency = document.getString("currency");
            return new ProductPrice(id,Double.parseDouble(price),currency);
        }
        return null;

    }
}
