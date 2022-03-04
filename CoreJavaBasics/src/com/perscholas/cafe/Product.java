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

    public abstract void addOptions(int option) throws InvalidOptionException;

    public abstract void printOptions();

    public abstract Product getInstance();

    public void printPrompt() {
        System.out.printf("Please enter quantity for %s:%n", name);
    }

    @Override
    public String toString() {
        return String.format("Item:\t%-16sPrice: $%.2f\tQty: %d\tSubtotal: $%.2f", 
            name, price, quantity, calculateProductSubtotal());
    }

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
