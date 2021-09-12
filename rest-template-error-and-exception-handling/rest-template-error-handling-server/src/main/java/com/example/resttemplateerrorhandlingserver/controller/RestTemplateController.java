package com.example.resttemplateerrorhandlingserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server")
public class RestTemplateController {

    @PostMapping
    public ResponseEntity<String> testMethod(@RequestBody String message){
        System.out.println(message);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
