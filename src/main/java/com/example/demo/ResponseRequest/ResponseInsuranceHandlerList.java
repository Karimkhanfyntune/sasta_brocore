package com.example.demo.ResponseRequest;

import java.util.List;
import java.util.Set;

public class ResponseInsuranceHandlerList {

    private List<String> message;

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    private Boolean status;

    public ResponseInsuranceHandlerList(List<String> message, Boolean status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseInsuranceHandlerList() {
    }

    private Object data;


}
