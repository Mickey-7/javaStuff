package com.example.replicate.config;

import com.example.replicate.util.GenerateXML;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GenerateXMLConfig {
    @Bean(name = "generateXML")
    public GenerateXML generateXMLBean(){
        return new GenerateXML();
    }
}
