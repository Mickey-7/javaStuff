package com.example.consumeapiresttemplateserver.model;

public class Person {

    private Integer id;
    private String firstName;
    private Address address;

    public Person() {
    }

    public Person(Integer id, String firstName, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", address=" + address +
                '}';
    }
}
