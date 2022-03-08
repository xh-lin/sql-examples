package com.perscholas.applying_oop_to_jdbc.exceptions;

public class SQLConnectionException extends Exception {

    public SQLConnectionException(String message, String url, String username, String password) {
        super(String.format(
            "%s | url: %s | username: %s | password: %s", 
            message, url, username, password));
    }
    
}
