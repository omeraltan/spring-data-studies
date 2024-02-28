package com.spring.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "t_owner")
public class Owner {
    @Embeddable
    public static class OwnerId implements Serializable{
        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

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
    }

    @Id
    private OwnerId id;

    public OwnerId getId() {
        return id;
    }

    public void setId(OwnerId id) {
        this.id = id;
    }
}
