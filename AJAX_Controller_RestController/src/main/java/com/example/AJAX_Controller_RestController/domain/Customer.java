package com.example.AJAX_Controller_RestController.domain;

public class Customer {
    private String name;
    private String age;
    private Address address;

    public Customer() {
    }

    public Customer(String name, String age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address=" + address +
                '}';
    }
}
