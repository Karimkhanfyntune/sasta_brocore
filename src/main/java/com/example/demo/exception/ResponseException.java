package com.example.demo.exception;

import java.util.List;
import java.util.Map;

public class ResponseException {
    private boolean status;
    private List<Map<String, String>> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Map<String, String>> getData() {
        return data;
    }

    public void setData(List<Map<String, String>> data) {
        this.data = data;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public ResponseException(boolean status, List<Map<String, String>> data, List<String> messages) {
        this.status = status;
        this.data = data;
        this.messages = messages;
    }

    public ResponseException() {
    }

    private List<String> messages; // Add this to store multiple error messages

    // Constructors, getters, and setters
}
