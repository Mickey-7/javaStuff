package com.example.consumeapiresttemplateclient.model;

public class Address {

    private String village;
    private String district;
    private String state;

    public Address() {
    }

    public Address(String village, String district, String state) {
        this.village = village;
        this.district = district;
        this.state = state;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "village='" + village + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
