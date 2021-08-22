package com.example.springbootqualifier.model;


public class Manager implements Person{
    @Override
    public String info() {
        return "Manager";
    }
}
