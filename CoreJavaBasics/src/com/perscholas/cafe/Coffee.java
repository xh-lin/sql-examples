package com.perscholas.cafe;

public class Coffee extends Product {

    private boolean sugar;
    private boolean milk;

    Coffee() {
        super();
    }

    Coffee(String name, float price, String description) {
        super(name, price, description);
    }

    Coffee(String name, float price, String description, boolean sugar, boolean milk) {
        super(name, price, description);
        this.sugar = sugar;
        this.milk = milk;
    }

    @Override
    public float calculateProductSubtotal() {
        return getQuantity() * getPrice();
    }
    
    /*
        Getters & Setters
    */

    public boolean isSugar() {
        return this.sugar;
    }

    public boolean getSugar() {
        return this.sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    public boolean isMilk() {
        return this.milk;
    }

    public boolean getMilk() {
        return this.milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

}
