package com.perscholas.cafe;

public class Store extends ProductContainer {

    Store() {
        super();
    }

    Store(Product... products) {
        super(products);
    }

    public Product select(int option) throws InvalidOptionException {
        if (option >= 1 && option <= products.size()) { // option is 1-based
            return products.get(option - 1).getInstance();
        } else if (option == products.size() + 1) { // checkout
            return null;
        } else {
            throw new InvalidOptionException(
                String.format("Please select a number between 1 and %d:", products.size() + 1));
        }
    }
    
    public void printMenu() {
        System.out.println("Please select from the following menu:");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d: %s\t$%.2f\t%s%n", i+1, products.get(i).getName(), products.get(i).getPrice(), products.get(i).getDescription());
        }
        System.out.printf("%d: Check Out%n", products.size() + 1);
    }

}
