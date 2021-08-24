package com.example.consumeapiresttemplateserver.controller;

import com.example.consumeapiresttemplateserver.model.Address;
import com.example.consumeapiresttemplateserver.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-rest/data/")
public class ServerController {

    @RequestMapping(value = "/fetch/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getForObject(@PathVariable(value = "id") Integer id){
        Address address = new Address("address1","address1","address1");
        return new Person(id,"person1",address);
    }

    @RequestMapping(value = "/exchange/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> exchange(@PathVariable(value = "id") Integer id){
        Address address = new Address("address2","address2","address2");
        Person person = new Person(id, "person2",address);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }


}
