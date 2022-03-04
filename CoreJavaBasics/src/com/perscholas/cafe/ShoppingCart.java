package com.perscholas.cafe;

public class ShoppingCart extends ProductContainer {

    private static final float SALES_TAX_PCT = 0.0625f;
    
    ShoppingCart() {
        super();
    }

    ShoppingCart(Product... products) {
        super(products);
    }

    public void printCheckout() {
        float purchaseSubtotal = 0f;

        for (Product product : products) {
            purchaseSubtotal += product.calculateProductSubtotal();
            System.out.println(product);
        }

        float salesTax = purchaseSubtotal * SALES_TAX_PCT;
        float purchaseTotal = purchaseSubtotal + salesTax;
        System.out.printf("sales subtotal: $%.2f%nsales tax: $%.2f%nsales total: $%.2f%n", 
            purchaseSubtotal, salesTax, purchaseTotal);
    }

}
