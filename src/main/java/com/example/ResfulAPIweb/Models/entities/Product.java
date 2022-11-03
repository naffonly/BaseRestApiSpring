package com.example.ResfulAPIweb.Models.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tbl_product")
public  class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name is Required")
    @Column(name = "productName", length = 100)
    private  String name;
    @NotEmpty(message = "Description is Required")
    @Column(name = "productDecs", length = 500)
    private  String decs;


    @NotBlank(message = "Price is Reequired")
    private  double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(Integer id, String name, String decs, double price) {
        this.id = id;
        this.name = name;
        this.decs = decs;
        this.price = price;
    }

    public Product() {


    }
}