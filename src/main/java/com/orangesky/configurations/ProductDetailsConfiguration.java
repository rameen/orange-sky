package com.orangesky.configurations;

import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Environment;

/**
 * @author RaminderSingh
 */
public class ProductDetailsConfiguration {
    private String host;
    private String url;

    public ProductDetailsConfiguration() {
    }

    public ProductDetailsConfiguration(String host, String url) {

        this.host = host;
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
