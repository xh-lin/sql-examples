package com.perscholas.cafe;

public class Espresso extends Product {

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
