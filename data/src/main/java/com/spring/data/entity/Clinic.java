package com.spring.data.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_clinic")
public class Clinic extends BaseEntity{
    private String name;
    @OneToMany
    @JoinTable(name = "t_clinic_owner", joinColumns = @JoinColumn(name = "clinic_id"), inverseJoinColumns = @JoinColumn(name = "pet_owner_id"))
    private Set<Pet_Owner> pet_owners = new HashSet<>();
    @OneToMany
    @JoinTable(name = "t_clinic_vet", joinColumns = @JoinColumn(name = "clinic_id"), inverseJoinColumns = @JoinColumn(name = "vet_id"))
    private Set<Vet> vet = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pet_Owner> getPet_owners() {
        return pet_owners;
    }

    public void setPet_owners(Set<Pet_Owner> pet_owners) {
        this.pet_owners = pet_owners;
    }

    public Set<Vet> getVet() {
        return vet;
    }

    public void setVet(Set<Vet> vet) {
        this.vet = vet;
    }
}
