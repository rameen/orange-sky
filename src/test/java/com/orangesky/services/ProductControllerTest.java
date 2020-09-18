package com.orangesky.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orangesky.OrangeSkyApplication;
import com.orangesky.configurations.AppConfigurations;
import com.orangesky.dao.ProductDetails;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author RaminderSingh
 */
public class ProductControllerTest {


    @ClassRule
    public static final DropwizardAppRule<AppConfigurations> EXT = new DropwizardAppRule<>(OrangeSkyApplication.class, ResourceHelpers.resourceFilePath("app-config-test.yml"));
    public static final int DUMMY_PRODUCT_ID = 12345679;

    private String localhost = "http://localhost:%d";
    private String productsPath ="/products/";


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductControllerTest.class);

    private Client client ;

    @Before
    public void setUp() {
        client = EXT.client();

    }

    @Test
    public void  testPriceDetailsForTheDummyProductId200Status() throws JsonProcessingException {

        Integer productId = DUMMY_PRODUCT_ID;

        Response response = getResponse(productId);
        assertEquals(HttpStatus.OK_200,response.getStatus());
    }



    @Test
     public void  testPriceDetailsForTheDummyProductId() throws JsonProcessingException {

        Integer productId = DUMMY_PRODUCT_ID;

        ProductDetails productDetails = getProductDetails(productId);

        assertNotNull(productDetails);
        assertNotNull(productDetails.getId());
        assertNotNull(productDetails.getTitle());
        assertNotNull(productDetails.getPriceDetails());
        assertNotNull(productDetails.getPriceDetails().getValue());
        assertNotNull(productDetails.getPriceDetails().getCurrency());
    }


    @Test
    public void  testProductTitleForTheDummyProductId() throws JsonProcessingException {

        Integer productId = 12345679;

        ProductDetails productDetails = getProductDetails(productId);

        assertNotNull(productDetails);
        assertEquals(productId, productDetails.getId());
        assertEquals("Dummy Product Title", productDetails.getTitle());
    }


    @Test
    public void testProductIdWithSomethingWentWrong(){
        Integer invalidProductId = 1000;
        Response response = getResponse(invalidProductId);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR_500,response.getStatus());

    }


    private ProductDetails getProductDetails(Integer productId) {
        return client.target(
                String.format(localhost + productsPath + productId, EXT.getLocalPort()))
                .request()
                .get(ProductDetails.class);
    }
    private Response getResponse(Integer productId) {
        return client.target(
                String.format(localhost + productsPath + productId, EXT.getLocalPort()))
                .request()
                .get();
    }
    @After
    public void tearDown() {
        client = null;
    }
}