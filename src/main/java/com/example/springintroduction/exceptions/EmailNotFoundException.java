package com.example.springintroduction.exceptions;

public class EmailNotFoundException extends Exception {

    public EmailNotFoundException(String message) {
        super(message);
    }
}
