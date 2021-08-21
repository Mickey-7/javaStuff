package com.example.SpringBootJSP.controller;

import com.example.SpringBootJSP.domain.Person;
import com.example.SpringBootJSP.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){


        model.addAttribute("message","JSP on SpringBoot");


        return "hello";
    }

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> indexAJAX(){

        List<Person> people = personRepository.findAll();
        Person person = new Person("name","description");
        Person person1 = new Person("name1","description1");
        Person person2 = new Person("name2","description2");

        people.add(person);
        people.add(person1);
        people.add(person2);


        return new ResponseEntity<List<Person>>(people, HttpStatus.OK);
    }




}
