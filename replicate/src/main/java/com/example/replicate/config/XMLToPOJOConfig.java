package com.example.replicate.config;

import com.example.replicate.util.XMLToPOJO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class XMLToPOJOConfig {
    @Bean(name = "XMLToPOJOBean")
    public XMLToPOJO createXMLToPOJOBean(){
        return new XMLToPOJO();
    }
}
