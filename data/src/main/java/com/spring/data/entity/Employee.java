package com.spring.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@SecondaryTable(name = "t_inform",pkJoinColumns = @PrimaryKeyJoinColumn(name = "employee_id"))
@Entity
@Table(name = "t_employee")
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private int status;
    @Embedded
    private OtherInformations otherInformations;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, int age, double salary, int status) {
        setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public Employee(Long id, String firstName, String lastName, int age, double salary, int status, OtherInformations otherInformations) {
        setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.otherInformations = otherInformations;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OtherInformations getOtherInformations() {
        return otherInformations;
    }

    public void setOtherInformations(OtherInformations otherInformations) {
        this.otherInformations = otherInformations;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            ", salary=" + salary +
            ", status=" + status +
            ", otherInformations=" + otherInformations +
            '}';
    }
}
