package com.orangesky.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author RaminderSingh
 */
@Path("/test")
public class HelloWorldController {

    @GET
    public String greetings(){
        return "Hello ! Welcome to dropwizard!!";
    }
}
