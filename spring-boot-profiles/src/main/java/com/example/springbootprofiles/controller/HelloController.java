package com.example.springbootprofiles.controller;

import com.example.springbootprofiles.sevice.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Animal animal;

    @Value("${message}")
    private String messageFromProd;

    @GetMapping("/")
    public String getMessage(){
        System.out.println(messageFromProd);
        return animal.getMessage();
    }
}
