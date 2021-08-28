package com.example.jsonanygetterjsonanysetter.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Address {
    private Map<String,String> addressDetails = new LinkedHashMap<>();

    public Address() {
    }

    public Address(Map<String, String> addressDetails) {
        this.addressDetails = addressDetails;
    }

    @JsonAnyGetter
    public Map<String, String> getAddressDetails() {
        return addressDetails;
    }

    @JsonAnySetter
    public void setAddressDetails(Map<String, String> addressDetails) {
        this.addressDetails = addressDetails;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressDetails=" + addressDetails +
                '}';
    }
}
