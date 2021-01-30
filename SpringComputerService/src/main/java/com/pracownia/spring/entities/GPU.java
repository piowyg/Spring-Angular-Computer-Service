package com.pracownia.spring.entities;

import javax.persistence.*;

@Entity
@Table(name = "GPU")
public class GPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    private int price;

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public GPU() {
    }
}
