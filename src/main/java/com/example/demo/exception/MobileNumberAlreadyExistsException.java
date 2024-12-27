package com.example.demo.exception;

public class MobileNumberAlreadyExistsException extends RuntimeException {
    public MobileNumberAlreadyExistsException(String message) {
        super(message);
    }
}
