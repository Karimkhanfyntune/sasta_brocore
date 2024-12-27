package com.example.demo.exception;

public class CustomTableNotFoundException extends RuntimeException {
    public CustomTableNotFoundException(String message) {
        super(message);
    }
}