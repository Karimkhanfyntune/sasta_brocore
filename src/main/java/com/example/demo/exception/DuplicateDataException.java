package com.example.demo.exception;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String message){
        super(message);

    }
}
