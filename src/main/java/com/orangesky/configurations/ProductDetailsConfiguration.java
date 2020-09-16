package com.orangesky.configurations;

/**
 * @author RaminderSingh
 */
public class ProductDetailsConfiguration {
    private String host;


    public ProductDetailsConfiguration() {
    }

    public ProductDetailsConfiguration(String host) {

        this.host = host;

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }


}
