package com.spring.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="t_specialty")
public class Specialty extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy="specialties")
    private Set<Vet> vets = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
