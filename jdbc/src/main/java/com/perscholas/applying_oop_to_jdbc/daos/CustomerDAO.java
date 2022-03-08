package com.perscholas.applying_oop_to_jdbc.daos;

import com.perscholas.applying_oop_to_jdbc.models.Customer;

public class CustomerDAO extends DAO implements CustomerDAOI {

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = new Customer();
        try {
            connect();
            ps = conn.prepareStatement(SQL.GET_CUSTOMER_BY_ID.getQuery());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                customer.setId(rs.getInt(1));
                customer.setEmail(rs.getString(2));
                customer.setFname(rs.getString(3));
                customer.setLname(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dispose();
        }
        return customer;
    }

    @Override
    public void addCustomer(Customer c) {
        try {
            connect();
            ps = conn.prepareStatement(SQL.ADD_CUSTOMER.getQuery());
            ps.setInt(1, c.getId());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getFname());
            ps.setString(4, c.getLname());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dispose();
        }
    }

    @Override
    public void removeCustomerById(int id) {
        try {
            connect();
            ps = conn.prepareStatement(SQL.REMOVE_CUSTOMER_BY_ID.getQuery());
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dispose();
        }
    }
    
}
