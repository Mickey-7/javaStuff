package com.example.springbootresttemplatejsonnodeserver.service;

import com.example.springbootresttemplatejsonnodeserver.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyRestService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${myrest.url}")
    private String restUrl;

    public User[] getUsers(){
        var users = restTemplate.getForObject(restUrl, User[].class);
        return users;
    }
}
