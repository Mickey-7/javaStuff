package com.example.springbootprofiles.sevice;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("animal_prod")
public class Lion implements Animal{
    @Override
    public String getMessage() {
        return "hello lion";
    }
}
