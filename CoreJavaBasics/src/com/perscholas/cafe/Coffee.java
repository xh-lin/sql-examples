package com.perscholas.cafe;

public class Coffee extends Product {

    private static final String SUGAR = "Sugar";
    private static final String MILK = "Milk";

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

    @Override
    public void addOptions(int option) throws InvalidOptionException {
        switch (option) {
            case 1:
                sugar = true;
                break;
            case 2:
                milk = true;
                break;
            case 3:
                sugar = true;
                milk = true;
                break;
            case 4:
                sugar = false;
                milk = false;
                break;
            default:
                throw new InvalidOptionException("Please select a number between 1 and 4:");
        }
    }

    @Override
    public void printOptions() {
        System.out.printf("Would you like the following options with the %s?%n", getName());
        System.out.printf("1: %s%n2: %s%n3: Both%n4: No Thanks%n", SUGAR, MILK);
    }

    @Override
    public Coffee getInstance() {
        return new Coffee(getName(), getPrice(), getDescription());
    }

    @Override
    public String toString() {
        return String.format("%s%n\t%s: %s\t%s: %s", 
            super.toString(), 
            SUGAR, sugar ? "Yes" : "No",
            MILK, milk ? "Yes" : "No");
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
