package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        System.out.println("hey");
        ModelAndView modelAndView = new ModelAndView("home");
        String message = "this is message";
        modelAndView.addObject("message",message);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String username = ((UserDetails) principal).getUsername();
            System.out.println(username);
        }else{
            String username = principal.toString();
            System.out.println("else "+username);
        }

        return "home";
    }

    @GetMapping("/another_home")
    public String anotherHome(){
        return "another_home";
    }

}
