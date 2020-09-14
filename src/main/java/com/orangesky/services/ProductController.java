package com.orangesky.services;

import com.orangesky.dao.ProductDetails;

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

    private IProductService productService = new ProductServiceImpl();
    @GET
    @Path("/{id}")
    public Response productDetails(@PathParam("id") Integer id){
        return Response.ok(productService.fetchProductDetails(id)).build();
    }
}
