package com.perscholas.applying_oop_to_jdbc;

import com.perscholas.applying_oop_to_jdbc.daos.CustomerDAO;
import com.perscholas.applying_oop_to_jdbc.daos.ItemDAO;
import com.perscholas.applying_oop_to_jdbc.models.Customer;
import com.perscholas.applying_oop_to_jdbc.models.Item;

/*
Database Tables:
    Customer - id(int), email(varchar2), fname(varchar2), lname(varchar2).
    Item - id(int), name(varchar2), price(Number(4,2)).
Create models for each table.
Create DAOs with the following methods:
    CustomerDAO
        getCustomerById(int id) - Returns the customer object for the given id.
        addCustomer(Customer c) - Adds a customer with given information.
        removeCustomerById(int id) - Removes a customer with the given id.
    ItemDAO
        getAllItems() - Returns a list of all item objects in the database.
        addItem(Item i) - Adds an item with given information.
        removeItemById(int id) - Removes an item with the given id.

*/
public class Main {

    private static void testCustomerDAO() {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer(99, "test@test.com", "First", "Last");

        System.out.println("add a customer");
        System.out.println(customer);
        customerDAO.addCustomer(customer);
        
        System.out.println("get a customer");
        System.out.println(customerDAO.getCustomerById(99));

        customerDAO.removeCustomerById(99);
        System.out.println("remove a customer");
        System.out.println(customerDAO.getCustomerById(99));
    }

    private static void testItemDAO() {
        ItemDAO itemDAO = new ItemDAO();
        Item item = new Item(99, "testItem", 10.59d);
        
        System.out.println("get all items");
        System.out.println(itemDAO.getAllItems());

        System.out.println("add an item");
        System.out.println(item);
        itemDAO.addItem(item);

        System.out.println("get all items");
        System.out.println(itemDAO.getAllItems());

        System.out.println("remove an item");
        itemDAO.removeItemById(99);

        System.out.println("get all items");
        System.out.println(itemDAO.getAllItems());
    }
    
    public static void main(String[] args) {
        testCustomerDAO();
        System.out.println();
        testItemDAO();
    }

}
