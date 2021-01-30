package com.pracownia.spring.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMPUTER")

public class Computer {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    private int price;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="CPU_id", referencedColumnName = "id")
    CPU cpu_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="GPU_id", referencedColumnName = "id")
    GPU gpu_id;

    @JsonManagedReference
    @OneToMany(mappedBy = "computer", fetch = FetchType.LAZY)
    private List<Memory> memory = new ArrayList<Memory>();

    @JsonManagedReference
    @OneToMany(mappedBy = "computer", fetch = FetchType.LAZY)
    private List<RamMemory> ramMemory = new ArrayList<>() {
    };


    public Computer(){}


    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id=id;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public CPU getCpu_id() {
        return cpu_id;
    }

    public void setCpu_id(CPU cpu) {
        this.cpu_id = cpu;
    }

    public GPU getGpu_id() {
        return gpu_id;
    }

    public void setGpu_id(GPU gpu_id) {
        this.gpu_id = gpu_id;
    }

    public List<Memory> getMemory() {
        return memory;
    }

    public void setMemory(List<Memory> memory) {
        this.memory = memory;
    }

    public List<RamMemory> getRamMemory() {
        return ramMemory;
    }

    public void setRamMemory(List<RamMemory> ramMemory) {
        this.ramMemory = ramMemory;
    }

}
