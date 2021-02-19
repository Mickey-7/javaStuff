package com.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean(name = "myBean")
    public ComponentClass myBean(){
        System.out.println("this is from Bean");
        return new ComponentClass();
    }

    @Bean(name = "soMany")
    public ComponentClass aClass(){
        System.out.println("thi is shit");
        return new ComponentClass();
    }
}
