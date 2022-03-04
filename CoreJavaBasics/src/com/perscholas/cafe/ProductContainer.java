package com.perscholas.cafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ProductContainer {
    
    List<Product> products;

    ProductContainer() {
        products = new ArrayList<>();
    }

    ProductContainer(Product... products) {
        this.products = new ArrayList<>(Arrays.asList(products));
    }
    
    /*
        Getters & Setters
    */

    public List<Product> getProducts() {
        return this.products;
    }

    public Product getProduct(int index) {
        return this.products.get(index);
    }

    public void addProducts(Product... products) {
        this.products.addAll(Arrays.asList(products));
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
    
}
