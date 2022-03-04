package com.perscholas.cafe;

public abstract class Product {
    
    private String name;
    private float price;
    private String description;
    private int quantity;

    Product() { }

    Product(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public abstract float calculateProductSubtotal();

    /*
        Getters & Setters
    */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
