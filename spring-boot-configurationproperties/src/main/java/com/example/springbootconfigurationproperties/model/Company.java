package com.example.springbootconfigurationproperties.model;

public class Company {
    private String name;
    private String ceo;
    private String location;

    public Company() {
    }

    public Company(String name, String ceo, String location) {
        this.name = name;
        this.ceo = ceo;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", ceo='" + ceo + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
