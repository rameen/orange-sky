package com.orangesky.exceptions;

import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.WebApplicationException;

/**
 * @author RaminderSingh
 */
public class ResourceNotFoundException extends WebApplicationException {

    public ResourceNotFoundException() {
        super("Resource Not Found", HttpStatus.NOT_FOUND_404);
    }


}
