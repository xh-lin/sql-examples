package com.example;

import java.util.Map;

public class CartSystem extends TheSystem {
    CartSystem() {
    }

    @Override
    public void display() {
        double preTaxTotal = 0d;
        System.out.println("Cart:");
        System.out.printf("%-20s %-20s %-10s %-10s %-10s%n",
            "Name", "Description", "Price", "Quantity", "Sub Total");
        for (Map.Entry<String, Item> entry : getItemCollection().entrySet()) {
            Item item = entry.getValue();
            double subTotal = item.getItemPrice() * item.getQuantity();
            preTaxTotal += subTotal;
            System.out.printf("%-20s %-20s %-10.2f %-10d %-10.2f%n",
                item.getItemName(), item.getItemDesc(), item.getItemPrice(),
                item.getAvailableQuantity(), subTotal);
        }
        double tax = preTaxTotal * 0.5d;
        double total = preTaxTotal + tax;
        System.out.printf("%-20s %-20.2f%n", "Pre-tax Total", preTaxTotal);
        System.out.printf("%-20s %-20.2f%n", "Tax", tax);
        System.out.printf("%-20s %-20.2f%n", "Total", total);
    }
}
