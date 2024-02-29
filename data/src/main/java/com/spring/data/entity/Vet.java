package com.spring.data.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_vet")
public class Vet extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "t_vet_speciality", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
