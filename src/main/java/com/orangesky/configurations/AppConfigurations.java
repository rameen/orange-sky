package com.orangesky.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

/**
 * @author RaminderSingh
 */
public class AppConfigurations extends Configuration {

    @JsonProperty("product_details_service")
    private ProductDetailsConfiguration productDetailsConfiguration = new ProductDetailsConfiguration();


    public ProductDetailsConfiguration getProductDetailsConfiguration() {
        return productDetailsConfiguration;
    }

    public void setProductDetailsConfiguration(ProductDetailsConfiguration productDetailsConfiguration) {
        this.productDetailsConfiguration = productDetailsConfiguration;
    }
}
