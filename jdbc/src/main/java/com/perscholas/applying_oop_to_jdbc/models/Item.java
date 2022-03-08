package com.perscholas.applying_oop_to_jdbc.models;

import java.util.StringJoiner;

public class Item {
    
    int id;
    String name;
    Double price;

    public Item() { }

    public Item(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        sj.add("id: " + id);
        sj.add("name: " + name);
        sj.add("price: " + price);
        return sj.toString();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
