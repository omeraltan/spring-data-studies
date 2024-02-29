package com.spring.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.annotations.Parent;

@Embeddable
public class Email {
    @Column(name = "email")
    private String email;

    @Parent
    private Pet_Owner pet_owner;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pet_Owner getPet_owner() {
        return pet_owner;
    }

    public void setPet_owner(Pet_Owner pet_owner) {
        this.pet_owner = pet_owner;
    }
}
