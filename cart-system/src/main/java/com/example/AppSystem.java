package com.example;

import java.util.Map;

public class AppSystem extends TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        System.out.println("AppSystem Inventory:");
        System.out.printf("%-20s %-20s %-10s %-10s%n",
            "Name", "Description", "Price", "Available Quantity");
        for (Map.Entry<String, Item> entry : getItemCollection().entrySet()) {
            Item item = entry.getValue();
            System.out.printf("%-20s %-20s %-10.2f %-10d%n",
                item.getItemName(), item.getItemDesc(), item.getItemPrice(),
                item.getAvailableQuantity());
        }
    }

    @Override      // this overwrites the parents class add method
    public Boolean add(Item item) {
        if (item == null) {
            return false;
        } else if (getItemCollection().containsKey(item.getItemName())) {
            System.out.printf("%s is already in the App System%n", item.getItemName());
            return false;
        }
        getItemCollection().put(item.getItemName(), item);
        return true;
    }

    public Item reduceAvailableQuantity(String item_name) {
        if (getItemCollection().containsKey(item_name)) {
            Item item = getItemCollection().get(item_name);
            int newAvaQuan = item.getAvailableQuantity() - 1;
            if (newAvaQuan == 0) {
                getItemCollection().remove(item_name);
            } else {
                item.setAvailableQuantity(newAvaQuan);
            }
            return item;
        }
        return null;
    }
}
