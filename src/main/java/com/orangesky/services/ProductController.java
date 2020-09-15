package com.orangesky.services;

import com.orangesky.configurations.ProductDetailsConfiguration;
import org.glassfish.jersey.client.JerseyClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * @author RaminderSingh
 */

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

    private final ProductDetailsConfiguration productDetailsConfiguration;
    private IProductService productService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductDetailsConfiguration productDetailsConfiguration, JerseyClient httpClient) {

        this.productDetailsConfiguration = productDetailsConfiguration;
        LOGGER.info("product details config " + this.productDetailsConfiguration.getHost());
        this.productService = new ProductServiceImpl(httpClient,productDetailsConfiguration);
    }


    @GET
    @Path("/{id}")
    public Response productDetails(@PathParam("id") Integer id){

        return Response.ok(productService.fetchProductDetails(id)).build();
    }
}