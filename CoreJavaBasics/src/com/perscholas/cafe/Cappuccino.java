package com.perscholas.cafe;

public class Cappuccino extends Product {

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
