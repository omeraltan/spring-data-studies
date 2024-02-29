package com.spring.data.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_pet")
public class Pet extends BaseEntity{

    private String name;
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Pet_Owner pet_owner;

    @OneToMany
    @JoinColumn(name = "pet_id")
    @OrderColumn(name = "visit_order")
    private List<Visit> visits = new ArrayList<>();

    public Pet() {
    }

    public Pet(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Pet_Owner getOwner() {
        return pet_owner;
    }

    public void setOwner(Pet_Owner owner) {
        this.pet_owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
            "name='" + name + '\'' +
            ", birthdate=" + birthdate +
            ", petType=" + petType +
            '}';
    }
}
