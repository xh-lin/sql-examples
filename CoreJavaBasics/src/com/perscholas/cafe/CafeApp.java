package com.perscholas.cafe;

import java.util.Scanner;

public class CafeApp {

    private static final String PLZ_ENTER_NUM = "Please enter a number";

    private static void printWaitInput() {
        System.out.print("> ");
    }

    public static void main(String[] args) {
        Product coffee = new Coffee("Coffee", 3.49f, "Espresso & water.");
        Product espresso = new Espresso("Espresso", 3.99f, "Double shot of our espresso.");
        Product cappuccino = new Cappuccino("Cappuccino", 4.99f, "Double shot espresso, steamed milk, topped with foam.");

        Store store = new Store(coffee, espresso, cappuccino);
        ShoppingCart shoppingCart = new ShoppingCart();

        System.out.println();
        store.printMenu();
        printWaitInput();
        Scanner sc = new Scanner(System.in);

        // menu selection
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                try {
                    Product product = store.select(sc.nextInt());
                    if (product == null) break; // checkout
                    sc.nextLine();

                    // quantity prompt
                    product.printPrompt();
                    printWaitInput();
                    while (sc.hasNext()) {
                        if (sc.hasNextInt()) {
                            int quantity = sc.nextInt();
                            if (quantity > 0) {
                                product.setQuantity(quantity);
                                break;
                            } else {
                                System.out.println("Please enter a quantity bigger than zero.");
                            }
                        } else {
                            System.out.println(PLZ_ENTER_NUM);
                        }
                        sc.nextLine();
                        printWaitInput();
                    }
                    
                    sc.nextLine();

                    // product option selection
                    System.out.println();
                    product.printOptions();
                    printWaitInput();
                    while (sc.hasNext()) {
                        if (sc.hasNextInt()) {
                            int option = sc.nextInt();
                            try {
                                product.addOptions(option);
                                break;
                            } catch (InvalidOptionException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println(PLZ_ENTER_NUM);
                        }
                        sc.nextLine();
                        printWaitInput();
                    }

                    // add product to shopping cart
                    shoppingCart.addProduct(product);
                    System.out.println();
                    System.out.println(product);
                    System.out.printf("%n%s added to shopping cart.%n%n", product.getName());
                    store.printMenu();
                } catch (InvalidOptionException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println(PLZ_ENTER_NUM);
            }

            sc.nextLine();
            printWaitInput();
        }

        sc.close();
        System.out.println();
        shoppingCart.printCheckout();
    }

}
