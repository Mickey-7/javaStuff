package com.example.resttemplateerrorhandlingclient.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        LOGGER.info("hasError method");
        return (clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
            || clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR
        );
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        LOGGER.info("handleError method");
        if(clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR){
            LOGGER.info("Server error");
        }else if(clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR){
            LOGGER.info("Client error");

            if(clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND){
                LOGGER.info("Status not found");
            }
        }
    }
}
