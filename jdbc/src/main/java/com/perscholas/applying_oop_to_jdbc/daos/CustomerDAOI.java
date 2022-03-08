package com.perscholas.applying_oop_to_jdbc.daos;

import com.perscholas.applying_oop_to_jdbc.models.Customer;

public interface CustomerDAOI {

    enum SQL {
        GET_CUSTOMER_BY_ID("SELECT * FROM customer WHERE id = ?"),
        ADD_CUSTOMER("INSERT customer VALUES(?, ?, ?, ?)"),
        REMOVE_CUSTOMER_BY_ID("DELETE FROM customer WHERE id = ?");
        private final String query;
        private SQL(String s) { this.query = s; }
        public String getQuery() { return query; }
    }

    public Customer getCustomerById(int id);

    public void addCustomer(Customer c);

    public void removeCustomerById(int id);

}
