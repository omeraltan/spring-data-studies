package com.spring.data.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String phone;

    public Address() {
    }

    public Address(String street, String phone) {
        this.street = street;
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
