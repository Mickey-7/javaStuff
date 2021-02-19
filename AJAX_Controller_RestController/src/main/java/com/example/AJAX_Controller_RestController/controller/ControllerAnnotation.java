package com.example.AJAX_Controller_RestController.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("message.properties")
public class ControllerAnnotation {
    @Value("${another.message}")
    private String text;


    @GetMapping("/try")
    public String test(Model model){
        model.addAttribute("render",text);
        return "test";
    }

    @GetMapping
    public String homepage(){
        return "index";
    }
}
