package com.codeclan.example.CoffeeTracker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coffeeshops")
public class CoffeeShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;
    @JsonBackReference
    @OneToMany(mappedBy = "coffeeShop", fetch = FetchType.LAZY)
    private List<Coffee> coffees;

    public CoffeeShop(String name, String region){
        this.name = name;
        this.region = region;
        this.coffees = new ArrayList<>();
    }

    public CoffeeShop(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }


}
