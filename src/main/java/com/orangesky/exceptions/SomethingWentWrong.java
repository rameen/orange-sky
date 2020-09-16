package com.orangesky.exceptions;

import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.WebApplicationException;
import javax.xml.ws.WebServiceException;

/**
 * @author RaminderSingh
 */
public class SomethingWentWrong extends WebApplicationException {

    public SomethingWentWrong() {
        super("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR_500);
    }
}
