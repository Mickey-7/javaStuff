package com.example.springbootresponseentity.controller;

import com.example.springbootresponseentity.model.Country;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping(value = "/getCountry")
    public ResponseEntity<Country> getCountry(){
        var c = new Country();
        c.setName("France");
        c.setPopulation(1);

        var headers = new HttpHeaders();
        headers.add("Responded","MyController");

        return ResponseEntity.accepted().headers(headers).body(c);

        //on postman
        // 202Accepted
        // 6 ms
        // 227 B

        //Headers on Response UI
        // KEY                  VALUE
        // Responded            MyController
        // Content-type         application.json
        // Transfer-Encoding    chunked
        // Date                 Sun, 22 Aug 2021 03:00:14 GMT
        // Keep-Alive           timeout=60
        // Connection           keep-alive

    }

    @RequestMapping("/getCountry2")
    @ResponseBody
    public Country getCountry2(){
        var c = new Country();
        c.setName("France2");
        c.setPopulation(2);

        return c;

        //on postman
        // 200OK
        // 8 ms
        // 197 B

        //Headers on Response UI
        // KEY                  VALUE
        // Content-type         application.json
        // Transfer-Encoding    chunked
        // Date                 Sun, 22 Aug 2021 03:00:14 GMT
        // Keep-Alive           timeout=60
        // Connection           keep-alive

    }

}
