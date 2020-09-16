package com.orangesky.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * @author RaminderSingh
 */
public class AppConfigurations extends Configuration {

    @JsonProperty("product_details_service")
    private ProductDetailsConfiguration productDetailsConfiguration = new ProductDetailsConfiguration();

    @JsonProperty("mongo_config")
    private MongoDbConfig mongoDbConfig = new MongoDbConfig();


    public ProductDetailsConfiguration getProductDetailsConfiguration() {
        return productDetailsConfiguration;
    }

    public void setProductDetailsConfiguration(ProductDetailsConfiguration productDetailsConfiguration) {
        this.productDetailsConfiguration = productDetailsConfiguration;
    }

    public MongoDbConfig getMongoDbConfig() {
        return mongoDbConfig;
    }

    public void setMongoDbConfig(MongoDbConfig mongoDbConfig) {
        this.mongoDbConfig = mongoDbConfig;
    }
}
