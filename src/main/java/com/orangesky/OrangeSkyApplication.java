package com.orangesky;

import com.orangesky.services.HelloWorldService;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author RaminderSingh
 */
public class OrangeSkyApplication extends Application<Configuration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrangeSkyApplication.class);

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new HelloWorldService());
    }

    public static void main(String[] args) throws Exception {
        new OrangeSkyApplication().run(args);
    }
}
