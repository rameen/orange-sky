package com.orangesky;

import com.orangesky.configurations.AppConfigurations;
import com.orangesky.services.HelloWorldController;
import com.orangesky.services.ProductController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author RaminderSingh
 */
public class OrangeSkyApplication extends Application<AppConfigurations> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrangeSkyApplication.class);

    @Override
    public void initialize(Bootstrap<AppConfigurations> bootstrap) {

    }

    public void run(AppConfigurations configuration, Environment environment) throws Exception {
        environment.jersey().register(new HelloWorldController());
        environment.jersey().register(new ProductController(configuration.getProductDetailsConfiguration(),new JerseyClientBuilder().build()));

    }

    public static void main(String[] args) throws Exception {
        new OrangeSkyApplication().run(args);
    }
}
