package org.example;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    int id;
    @Column
    String name;
    @Column
    int price;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="pimageid",referencedColumnName = "pimageid")
    ProductImage pi;
    public Product() {}
    public Product(int id, String name, int price, ProductImage pi) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pi = pi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductImage getPi() {
        return pi;
    }

    public void setPi(ProductImage pi) {
        this.pi = pi;
    }
}
