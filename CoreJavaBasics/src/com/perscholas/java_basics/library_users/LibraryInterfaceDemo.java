package com.perscholas.java_basics.library_users;

public class LibraryInterfaceDemo {

    private static void testCaseOne() {
        KidUser kidUser = new KidUser();
        kidUser.age = 10;
        kidUser.registerAccount();
        kidUser.age = 18;
        kidUser.registerAccount();
        kidUser.bookType = "Kids";
        kidUser.requestBook();
        kidUser.bookType = "Fiction";
        kidUser.requestBook();
    }

    private static void testCaseTwo() {
        AdultUser adultUser = new AdultUser();
        adultUser.age = 5;
        adultUser.registerAccount();
        adultUser.age = 23;
        adultUser.registerAccount();
        adultUser.bookType = "Kids";
        adultUser.requestBook();
        adultUser.bookType = "Fiction";
        adultUser.requestBook();
    }
    
    public static void main(String[] args) {
        testCaseOne();
        testCaseTwo();
    }

}
