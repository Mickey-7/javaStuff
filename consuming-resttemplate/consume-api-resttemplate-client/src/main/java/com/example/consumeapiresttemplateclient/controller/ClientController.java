package com.example.consumeapiresttemplateclient.controller;

import com.example.consumeapiresttemplateclient.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
    private static final String url = "http://localhost:8080/spring-rest/data/";
    @Autowired
    private RestTemplate restTemplate;

    public void getForObject(){
        Person person = restTemplate.getForObject(url+"/fetch/{id}",Person.class, 7);
        System.out.println(person);
    }

    public ResponseEntity<Person> exchange(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>("This is request body", headers);
        ResponseEntity<Person> responseEntity = restTemplate.exchange(url+"/exchange/{id}", HttpMethod.GET, requestEntity,Person.class, 7);
        System.out.println(responseEntity);
        return responseEntity;
    }
}
