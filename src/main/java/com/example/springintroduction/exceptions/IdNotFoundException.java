package com.example.springintroduction.exceptions;

public class IdNotFoundException extends Exception {

    public IdNotFoundException(String message) {
        super(message);
    }
}