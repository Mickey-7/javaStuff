package com.example.springbootqualifier.config;

import com.example.springbootqualifier.model.Manager;
import com.example.springbootqualifier.model.Person;
import com.example.springbootqualifier.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class PersonFactory {
    @Bean
    @Qualifier("manager")
    public Person createManager() {
        return new Manager();
    }

    @Bean
    @Qualifier("student")
    public Person createStudent() {
        return new Student();
    }
}
