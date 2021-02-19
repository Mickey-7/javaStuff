package com.springmvc;

import org.springframework.stereotype.Component;

@Component
public class ComponentClass {

    public String myComponentClass(){
        System.out.println("from ComponentClass method 1");
        return "method1";
    }

    public int damn(){
        System.out.println("from ComponentClass method 2");
        return 7;
    }
}
