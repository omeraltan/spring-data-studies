package com.spring.data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.*;



@Entity
@Table(name="t_pet")
@SequenceGenerator(name="seqGen",sequenceName="pet_seq")
public class Pet extends BaseEntity {

    @Basic(optional=false)
    @Column(name="pet_name",nullable=false)
    private String name;

    @Column(name="birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @OneToMany(orphanRemoval=true,fetch=FetchType.LAZY)
    @JoinColumn(name="pet_id")
    @OrderColumn(name="visit_order")
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(mappedBy="pet")
    @MapKey(name="filePath")
    private Map<String, Image> imagesByFilePath = new HashMap<>();

    public Pet() {

    }

    public Pet(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }



    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }



    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public Map<String, Image> getImagesByFilePath() {
        return imagesByFilePath;
    }

    public void setImagesByFilePath(Map<String, Image> imagesByFilePath) {
        this.imagesByFilePath = imagesByFilePath;
    }

    @Override
    public String toString() {
        return "Pet [id=" + getId() + ", name=" + name + ", birthDate=" + birthDate + "]";
    }
}
