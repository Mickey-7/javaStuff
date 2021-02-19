package com.example.AJAX_Controller_RestController.controller;

import com.example.AJAX_Controller_RestController.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class RestControllerAnnotation {
    List<Customer> customerList = new ArrayList<>();

    @GetMapping("/all")
    public List<Customer> getResource(){
        return customerList;
    }

    @PostMapping("/save")
    public String postCustomer(@RequestBody List<Customer> customers){
        customerList.addAll(customers);
        return "Post Successfully!";
    }
}
