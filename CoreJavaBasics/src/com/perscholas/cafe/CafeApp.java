package com.perscholas.cafe;

import java.util.Scanner;

public class CafeApp {

    private static final float SALES_TAX_PCT = 0.0625f;

    public static void main(String[] args) {
        Product coffee = new Product("coffee", 2.5f, "Espresso & water.");
        Product espresso = new Product("espresso", 3f, "Double shot of our espresso.");
        Product cappuccino = new Product("cappuccino", 3.5f, "Double shot espresso, steamed milk, topped with foam.");

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter quantity for " + coffee.getName() + ":");
        coffee.setQuantity(sc.nextInt());
        float coffeeSubtot = coffee.calculateProductSubtotal();
        System.out.printf("name: %s\ndescription: %s\nsubtotal: %.2f\n\n", coffee.getName(), coffee.getDescription(), coffeeSubtot);

        System.out.println("Please enter quantity for " + espresso.getName() + ":");
        espresso.setQuantity(sc.nextInt());
        float espressoSubtot = espresso.calculateProductSubtotal();
        System.out.printf("name: %s\ndescription: %s\nsubtotal: %.2f\n\n", espresso.getName(), espresso.getDescription(), espressoSubtot);

        System.out.println("Please enter quantity for " + cappuccino.getName() + ":");
        cappuccino.setQuantity(sc.nextInt());
        float cappuccinoSubtot = cappuccino.calculateProductSubtotal();
        System.out.printf("name: %s\ndescription: %s\nsubtotal: %.2f\n\n", cappuccino.getName(), cappuccino.getDescription(), cappuccinoSubtot);

        sc.close();

        float subtotal = coffeeSubtot + espressoSubtot + cappuccinoSubtot;
        float salesTax = subtotal * SALES_TAX_PCT;
        float salesTotal = subtotal + salesTax;
        System.out.printf("sales subtotal: %.2f\nsales tax: %.2f\nsales total: %.2f\n", subtotal, salesTax, salesTotal);
    }

}
