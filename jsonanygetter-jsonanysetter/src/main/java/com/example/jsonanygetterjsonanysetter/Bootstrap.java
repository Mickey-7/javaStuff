package com.example.jsonanygetterjsonanysetter;

import com.example.jsonanygetterjsonanysetter.model.Address;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Bootstrap {



    @EventListener(ContextRefreshedEvent.class)
    public void onInit() throws JsonProcessingException {

        //Object to JSON
        Address address = new Address();
        //invoking @JsonAnyGetter by using get method
        Map<String,String> usingGetMethod = address.getAddressDetails();
        usingGetMethod.put("this", "is");
        usingGetMethod.put("invoking", "the");
        usingGetMethod.put("@JsonAny", "method");
        usingGetMethod.put("on Address", "class");

        //Now serialize the Address class using ObjectMapper and print it.
        ObjectMapper getMapper = new ObjectMapper();
        String get = getMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
        System.out.println("Get");
        System.out.println(get);
        //without @JsonAnyGetter
        //{
        //  "addressDetails" : {
        //    "country" : "India",
        //    "district" : "Varanasi",
        //    "state" : "Uttar Pradesh",
        //    "village" : "ABCD"
        //  }
        //}
        //with @JsonAnyGetter
        //{
        //  "country" : "India",
        //  "district" : "Varanasi",
        //  "state" : "Uttar Pradesh",
        //  "village" : "ABCD"
        //}

        address.setAddressDetails(usingGetMethod);
        //Now serialize the Address class using ObjectMapper and print it.
        ObjectMapper setMapper = new ObjectMapper();
        String set = setMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
        System.out.println("Set");
        System.out.println(set);
    }
}
