package com.spring.data.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="t_person")
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Person extends BaseEntity {
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ElementCollection
    @CollectionTable(name="t_person_email",joinColumns=@JoinColumn(name="person_id"))
    private Set<Email> emails = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }



}
