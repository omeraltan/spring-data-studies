package com.spring.data.entity;

import jakarta.persistence.*;

import java.util.Date;
@SecondaryTable(name = "t_address",pkJoinColumns = @PrimaryKeyJoinColumn(name = "product_id")) // adres tablosundaki product ismi product_id
@Entity
public class Product extends BaseEntity{
    private String name;
    private double price;
    @Convert(converter = RatingAttributeConverter.class)
    //@Enumerated(EnumType.STRING)
    private Rating rating;
    @Temporal(TemporalType.TIMESTAMP)
    private Date productDate;
    @Embedded
    private Address address;

    public Product() {
    }

    public Product(Long id, String name, double price) {
        setId(id);
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, double price, Address address) {
        this(id, name, price);
        this.address = address;
    }

    public Product(Long id, String name, double price, Rating rating, Address address) {
        this(id, name, price);
        this.rating = rating;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", address=" + address +
            '}';
    }
}
