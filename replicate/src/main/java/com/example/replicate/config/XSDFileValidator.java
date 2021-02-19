package com.example.replicate.config;

import com.example.replicate.util.XMLValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class XSDFileValidator {
    @Bean(name = "XSDFileValidatorBean")
    public XMLValidator xsdFileValidator(){
        return new XMLValidator();
    }
}
