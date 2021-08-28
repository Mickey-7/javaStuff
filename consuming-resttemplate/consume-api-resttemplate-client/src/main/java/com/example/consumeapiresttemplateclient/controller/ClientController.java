package com.example.consumeapiresttemplateclient.controller;

import com.example.consumeapiresttemplateclient.model.Address;
import com.example.consumeapiresttemplateclient.model.Person;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {
    private static final String url = "http://localhost:8080/spring-rest/data/";
    @Autowired
    private RestTemplate restTemplate;

    //getForObject
    public void getForObject(){
        Person person = restTemplate.getForObject(url+"/fetch/{id}",Person.class, 7);
        System.out.println(person);
        //notice that the name is null because the field name on the server is firstName while on the client is name only
        //need to use @JsonProperty("firstName")
    }

    //exchange
    public void exchange(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>("This is request body", headers);
        ResponseEntity<Person> responseEntity = restTemplate.exchange(url+"/exchange/{id}", HttpMethod.GET, requestEntity,Person.class, 7);
        System.out.println(responseEntity);
    }

    //headForHeaders
    public void headForHeaders(){
        HttpHeaders headers = restTemplate.headForHeaders(url+"/fetch/{id}", 100);
        System.out.println(headers);
    }

    //getForEntity
    public void getForEntity(){
        Map<String,String> map = new HashMap<>();
        map.put("name","Mahesh");
        map.put("village","Punjab");
        ResponseEntity<Person> responseEntity = restTemplate.getForEntity(url+"/fetch/{name}/{village}", Person.class, map);
        System.out.println(responseEntity);
        //<200,Person{id=7, name='null', address=Address{village='Punjab', district='address2', state='address2'}},[Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Wed, 25 Aug 2021 10:55:16 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]>
        //notice that the name is null because the field name on the server is firstName while on the client is name only
        //need to use @JsonProperty("firstName")
    }

    //delete
    public void delete(){
        Map<String,String> map = new HashMap<>();
        map.put("name","Mahesh");
        map.put("village","Punjab");
        restTemplate.delete(url+"/delete/{name}/{village}",map);
    }

    //put
    public void put(){
        Map<String,String> map = new HashMap<>();
        map.put("id","7");
        map.put("name","eminem");
        Address address = new Address("village","address2","address2");
        restTemplate.put(url+"/put/{id}/{name}",address,map);
    }


    //postForObject()
    public void postForObject(){
        Map<String, String> map = new HashMap<>();
        map.put("id","7");
        map.put("name","gunner");
        Address address = new Address("village","district","state");
        Person person = restTemplate.postForObject(url+"/post/{id}/{name}",address,Person.class,map);
        System.out.println(person);

    }

    //postForLocation
    public void postForLocation(){
        Address address = new Address("add","dist","Sta");
        URI uri = restTemplate.postForLocation(url+"/uri/location/{id}/{name}",address,7,"gunner");
        System.out.println(uri.getPath());
    }


}
