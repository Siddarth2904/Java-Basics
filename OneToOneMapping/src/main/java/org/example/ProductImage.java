package org.example;

import jakarta.persistence.*;

@Entity
@Table
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pimageid;
    @Column
    String url;

    // Add default constructor
    public ProductImage() {}

    // Constructor without ID
    public ProductImage(String url) {
        this.url = url;
    }

    public int getId() {
        return pimageid;
    }

    public void setId(int pimageid) {
        this.pimageid = pimageid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
