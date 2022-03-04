package com.perscholas.cafe;

public class Cappuccino extends Product {

    private static final String PEPPERMINT = "Peppermint";
    private static final String WHIPPED_CREAM = "Whipped Cream";
    private static final float PEPPERMINT_PRICE = 2f;
    private static final float WHIPPED_CREAM_PRICE = 1f;

    private boolean peppermint;
    private boolean whippedCream;

    Cappuccino() {
        super();
    }

    Cappuccino(String name, float price, String description) {
        super(name, price, description);
    }

    Cappuccino(String name, float price, String description, boolean peppermint, boolean whippedCream) {
        super(name, price, description);
        this.peppermint = peppermint;
        this.whippedCream = whippedCream;
    }

    @Override
    public float calculateProductSubtotal() {
        return getQuantity() * (getPrice() + (peppermint ? PEPPERMINT_PRICE : 0) + (whippedCream ? WHIPPED_CREAM_PRICE : 0));
    }

    @Override
    public void addOptions(int option) throws InvalidOptionException {
        switch (option) {
            case 1:
                peppermint = true;
                break;
            case 2:
                whippedCream = true;
                break;
            case 3:
                peppermint = true;
                whippedCream = true;
                break;
            case 4:
                peppermint = false;
                whippedCream = false;
                break;
            default:
                throw new InvalidOptionException("Please select a number between 1 and 4");
        }
    }

    @Override
    public void printOptions() {
        System.out.printf("Would you like the following options with the %s?%n", getName());
        System.out.printf("1: %s%n2: %s%n3: Both%n4: No Thanks%n", PEPPERMINT, WHIPPED_CREAM);
    }

    @Override
    public Cappuccino getInstance() {
        return new Cappuccino(getName(), getPrice(), getDescription());
    }

    @Override
    public String toString() {
        return String.format("%s%n\t%s: %s\t%s: %s", 
            super.toString(), 
            PEPPERMINT, peppermint ? String.format("Yes (Add $%.2f)", PEPPERMINT_PRICE) : "No",
            WHIPPED_CREAM, whippedCream ? String.format("Yes (Add $%.2f)", WHIPPED_CREAM_PRICE) : "No");
    }

    /*
        Getters & Setters
    */
    
    public boolean isPeppermint() {
        return this.peppermint;
    }

    public boolean getPeppermint() {
        return this.peppermint;
    }

    public void setPeppermint(boolean peppermint) {
        this.peppermint = peppermint;
    }

    public boolean isWhippedCream() {
        return this.whippedCream;
    }

    public boolean getWhippedCream() {
        return this.whippedCream;
    }

    public void setWhippedCream(boolean whippedCream) {
        this.whippedCream = whippedCream;
    }

}
