package com.spring.data.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_pet_owner")
public class Pet_Owner extends BaseEntity{
    private Rating rating;
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @OneToMany(mappedBy = "pet_owner")
    //@JoinColumn(name = "owner_id")
    private Set<Pet> pets = new HashSet<>();
    @ElementCollection
    @CollectionTable(name = "t_pet_owner_emails", joinColumns = @JoinColumn(name = "pet_owner_id"))
    private Set<Email> emails = new HashSet<>();

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

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

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
