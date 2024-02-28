package com.spring.data.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_pet")
public class Pet extends BaseEntity{

    private String name;
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

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

    @Override
    public String toString() {
        return "Pet{" +
            "name='" + name + '\'' +
            ", birthdate=" + birthdate +
            ", petType=" + petType +
            '}';
    }
}
