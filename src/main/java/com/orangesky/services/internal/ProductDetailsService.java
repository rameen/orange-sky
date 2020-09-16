package com.orangesky.services.internal;

import com.orangesky.configurations.ProductDetailsConfiguration;
import com.orangesky.dao.internal.ProductTitle;
import org.eclipse.jetty.http.HttpStatus;
import org.glassfish.jersey.client.JerseyClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author RaminderSingh
 */
public class ProductDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDetailsService.class);
    private final JerseyClient httpClient;
    private final ProductDetailsConfiguration productDetailsConfiguration;


    public ProductDetailsService(JerseyClient httpClient, ProductDetailsConfiguration productDetailsConfiguration) {
        this.httpClient = httpClient;
        this.productDetailsConfiguration = productDetailsConfiguration;
    }

    public ProductTitle fetchData(Integer id) {
        WebTarget endPoint = getWebTarget(id);
        if (endPoint == null) return null;
        Invocation.Builder invocationBuilder =  endPoint.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        if (response !=null && response.getStatus() == HttpStatus.OK_200) {
            ProductTitle productTitle = response.readEntity(ProductTitle.class);
            return productTitle;
        }

        if (id == 12345679){
            // For testing and demo purpose
            ProductTitle productTitle = new ProductTitle();
            productTitle.setTitle("Dummy Product Title");
            return productTitle;
        }

        return null;

    }

    private WebTarget getWebTarget(Integer id) {
        UriBuilder uriBuilder = null;
        try {
            uriBuilder = UriBuilder.fromUri(new URI(productDetailsConfiguration.getHost()+id));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
        uriBuilder.queryParam("excludes","taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics");
        WebTarget endPoint = httpClient.target(uriBuilder);
        LOGGER.info(" Product Title Api  " + endPoint.toString());
        return endPoint;
    }
}
