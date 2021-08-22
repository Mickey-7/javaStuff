package com.example.springbootqualifier.model;



public class Student implements Person{
    @Override
    public String info() {
        return "Student";
    }
}
