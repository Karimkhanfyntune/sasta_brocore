package com.example.demo.Enum;

public enum LeadStatus {
    ACTIVE("Active"),
    IN_PROGRESS("In Progress"),
    INACTIVE("Inactive"),
    NEW("New"),
    SUCCESS("Success");

    private final String value;

    LeadStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
