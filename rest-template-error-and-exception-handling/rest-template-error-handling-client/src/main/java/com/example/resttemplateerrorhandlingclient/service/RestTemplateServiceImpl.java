package com.example.resttemplateerrorhandlingclient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateServiceImpl implements RestTemplateService{

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void restTemplatePost() {
        String url = "http://localhost:8080/server";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>("this is from client to server", httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST,requestEntity,String.class);
        LOGGER.info("{}",responseEntity);
    }
}
