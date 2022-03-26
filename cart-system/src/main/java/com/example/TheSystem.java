package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {

    private static final String PATH = "/resources";
    private static final String FILENAME = "sample.txt";

    private HashMap<String, Item> itemCollection;

    TheSystem() {
        itemCollection = new HashMap<>();

        if (this instanceof AppSystem) {
            String workingDirectory = System.getProperty("user.dir");
            File file = new File(workingDirectory + PATH, FILENAME);
            readFile(file);
        }
    }

    public HashMap<String, Item> getItemCollection(){
        return itemCollection;
    }

    public Boolean checkAvailability(Item item) {
        if (item != null && item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.printf("System is unable to add %s to the card. System only has %d %ss.%n",
                item.getItemName(), item.getQuantity(), item.getItemName());
                return false;
        }
        return true;
    }

    public Boolean add(Item item) {
        if (item == null) {
            return false;
        } else if (itemCollection.containsKey(item.getItemName())
                && checkAvailability(itemCollection.get(item.getItemName()))) {
            Item it = itemCollection.get(item.getItemName());
            it.setQuantity(item.getQuantity() + 1);
            return true;
        } else if (!itemCollection.containsKey(item.getItemName())) {
            itemCollection.put(item.getItemName(), item);
            return true;
        }
        return false;
    }

    public Item remove(String itemName) {
        if (itemCollection.containsKey(itemName)) {
            return itemCollection.remove(itemName);
        }
        return null;
    }

    public abstract void display();

    private void readFile(File file) {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split("\\s\\s");
                Item item = new Item(
                    line[0],
                    line[1],
                    Double.parseDouble(line[2]),
                    Integer.parseInt(line[3]));
                itemCollection.put(line[0], item);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
