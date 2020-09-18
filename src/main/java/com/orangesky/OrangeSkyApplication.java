package com.orangesky;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.orangesky.configurations.AppConfigurations;
import com.orangesky.managed.MongoManaged;
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
        LOGGER.info(" mongo config " + configuration.getMongoDbConfig().getMongoHost());
        MongoClient mongoClient = new MongoClient(configuration.getMongoDbConfig().getMongoHost(),configuration.getMongoDbConfig().getMongoPort());
        MongoDatabase mongoDatabase = mongoClient.getDatabase(configuration.getMongoDbConfig().getMongoDB());
        MongoManaged mongoManaged = new MongoManaged(mongoClient);
        environment.lifecycle().manage(mongoManaged);
        environment.healthChecks().register("data",new ApplicationHealthCheck());
        environment.jersey().register(new HelloWorldController());
        environment.jersey().register(new ProductController(configuration.getProductDetailsConfiguration(),new JerseyClientBuilder().build(),mongoDatabase));

    }

    public static void main(String[] args) throws Exception {
        new OrangeSkyApplication().run(args);
    }
}
