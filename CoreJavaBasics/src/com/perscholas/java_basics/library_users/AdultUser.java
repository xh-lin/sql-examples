package com.perscholas.java_basics.library_users;

public class AdultUser implements LibraryUser {
    
    int age;
    String bookType;

    @Override
    public void registerAccount() {
        System.out.println(
            age > 12 
            ? "You have successfully registered under an Adult Account" 
            : "Sorry, Age must be greater than 12 to register as an adult");
    }

    @Override
    public void requestBook() {
        System.out.println(
            bookType.equals("Fiction")
            ? "Book Issued successfully, please return the book within 7 days"
            : "Oops, you are allowed to take only adult Fiction books");
    }
    
}
