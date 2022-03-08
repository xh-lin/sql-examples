package com.perscholas.applying_oop_to_jdbc.models;

import java.util.StringJoiner;

public class Customer {
    
    int id;
    String email;
    String fname;
    String lname;
    
    public Customer() { }

    public Customer(int id, String email, String fname, String lname) {
        this.id = id;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        sj.add("id: " + id);
        sj.add("email: " + email);
        sj.add("fname: " + fname);
        sj.add("lname: " + lname);
        return sj.toString();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

}
