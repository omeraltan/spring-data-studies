package com.spring.data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Embeddable
public class Address {

    @Column(table = "t_address")
    private String street;
    @Column(table = "t_address")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "city_id", table = "t_address", foreignKey = @ForeignKey(name = "fk_address_city"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private City city;

    public Address() {
    }

    public Address(String street, String phone) {
        this.street = street;
        this.phone = phone;
    }

    public Address(String street, String phone, City city) {
        this(street, phone);
        this.city = city;
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
