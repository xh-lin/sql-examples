package com.perscholas.cafe;

public class Espresso extends Product {

    private static final String EXTRA_SHOT = "Extra Shot";
    private static final String MACCHIATO = "Macchiato";
    private static final float EXTRA_SHOT_PRICE = 2f;
    private static final float MACCHIATO_PRICE = 1f;

    private boolean extraShot;
    private boolean macchiato;

    Espresso() {
        super();
    }

    Espresso(String name, float price, String description) {
        super(name, price, description);
    }

    Espresso(String name, float price, String description, boolean extraShot, boolean macchiato) {
        super(name, price, description);
        this.extraShot = extraShot;
        this.macchiato = macchiato;
    }

    @Override
    public float calculateProductSubtotal() {
        return getQuantity() * (getPrice() + (extraShot ? EXTRA_SHOT_PRICE : 0) + (macchiato ? MACCHIATO_PRICE : 0));
    }

    @Override
    public void addOptions(int option) throws InvalidOptionException {
        switch (option) {
            case 1:
                extraShot = true;
                break;
            case 2:
                macchiato = true;
                break;
            case 3:
                extraShot = true;
                macchiato = true;
                break;
            case 4:
                extraShot = false;
                macchiato = false;
                break;
            default:
                throw new InvalidOptionException("Please select a number between 1 and 4");
        }
    }

    @Override
    public void printOptions() {
        System.out.printf("Would you like the following options with the %s?%n", getName());
        System.out.printf("1: %s%n2: %s%n3: Both%n4: No Thanks%n", EXTRA_SHOT, MACCHIATO);
    }

    @Override
    public Espresso getInstance() {
        return new Espresso(getName(), getPrice(), getDescription());
    }

    @Override
    public String toString() {
        return String.format("%s%n\t%s: %s\t%s: %s", 
            super.toString(), 
            EXTRA_SHOT, extraShot ? String.format("Yes (Add $%.2f)", EXTRA_SHOT_PRICE) : "No",
            MACCHIATO, macchiato ? String.format("Yes (Add $%.2f)", MACCHIATO_PRICE) : "No");
    }

    /*
        Getters & Setters
    */

    public boolean isExtraShot() {
        return this.extraShot;
    }

    public boolean getExtraShot() {
        return this.extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isMacchiato() {
        return this.macchiato;
    }

    public boolean getMacchiato() {
        return this.macchiato;
    }

    public void setMacchiato(boolean macchiato) {
        this.macchiato = macchiato;
    }

}
