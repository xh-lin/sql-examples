package com.perscholas.java_basics.library_users;

public class KidUser implements LibraryUser {

    int age;
    String bookType;

    @Override
    public void registerAccount() {
        System.out.println(
            age < 12 
            ? "You have successfully registered under a Kids Account" 
            : "Sorry, Age must be less than 12 to register as a kid");
    }

    @Override
    public void requestBook() {
        System.out.println(
            bookType.equals("Kids")
            ? "Book Issued successfully, please return the book within 10 days"
            : "Oops, you are allowed to take only kids books");
    }
    
}
