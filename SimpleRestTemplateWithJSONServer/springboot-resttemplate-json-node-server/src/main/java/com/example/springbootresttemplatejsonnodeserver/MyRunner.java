package com.example.springbootresttemplatejsonnodeserver;

import com.example.springbootresttemplatejsonnodeserver.service.MyRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private MyRestService myRestService;

    @Override
    public void run(String... args) throws Exception {
        var users = myRestService.getUsers();

        Arrays.stream(users).limit(10).forEach(todo -> logger.info("{}",todo));
    }
}
