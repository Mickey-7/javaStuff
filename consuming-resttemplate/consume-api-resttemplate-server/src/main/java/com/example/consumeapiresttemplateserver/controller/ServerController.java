package com.example.consumeapiresttemplateserver.controller;

import com.example.consumeapiresttemplateserver.model.Address;
import com.example.consumeapiresttemplateserver.model.Person;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/spring-rest/data/")
public class ServerController {

    //getForObject
    @RequestMapping(value = "/fetch/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getForObject(@PathVariable(value = "id") Integer id){
        Address address = new Address("address1","address1","address1");
        return new Person(id,"person1",address);
    }

    //exchange
    @RequestMapping(value = "/exchange/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> exchange(@PathVariable(value = "id") Integer id){
        Address address = new Address("address2","address2","address2");
        Person person = new Person(id, "person2",address);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    //headForHeaders
    @RequestMapping(value = "/fetch/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> getManuallyCreatedJSON(@PathVariable(value = "id") Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }

    //getForEntity
    @RequestMapping(value = "/fetch/{name}/{village}")
    public Person getForEntity(@PathVariable(value = "name") String name, @PathVariable(value = "village") String village){
        Address address = new Address(village,"address2","address2");
        return new Person(7,name,address);
    }

    //delete
    @RequestMapping(value = "/delete/{name}/{village}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "name") String name, @PathVariable(value = "village") String village){
        System.out.println("Deleting name : "+name+" and village : "+village);
    }

    //put
    @RequestMapping(value = "/put/{id}/{name}", method = RequestMethod.PUT)
    public void put(@PathVariable(value = "id") Integer id, @PathVariable(value = "name") String name, @RequestBody Address address){
        System.out.println("id : "+id+" ,name : "+name);
        System.out.println("district : "+address.getDistrict());
        System.out.println("village : "+address.getVillage());

    }

    //postForObject
    @RequestMapping(value = "/post/{id}/{name}",method = RequestMethod.POST)
    public ResponseEntity<Person> postForObject(@PathVariable(value = "id") Integer id,@PathVariable(value = "name") String name,@RequestBody Address address){
        Person person = new Person(id,name,address);
        return new ResponseEntity<>(person,HttpStatus.CREATED);
    }

    //postForLocation
    @RequestMapping(value = "/uri/location/{id}/{name}",method = RequestMethod.POST)
    public ResponseEntity<Void> postForLocation(
            @PathVariable(value = "id") Integer id,
            @PathVariable(value = "name") String name,
            @RequestBody Address address,
            UriComponentsBuilder builder
    ){
        System.out.println("id : "+id+", name : "+name);
        System.out.println(address);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/uri/location/{id}/{name}")
            .buildAndExpand(id,name).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }



}
