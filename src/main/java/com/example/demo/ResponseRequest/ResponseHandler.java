package com.example.demo.ResponseRequest;

import java.io.Serializable;


public class ResponseHandler implements Serializable {

	private Boolean status;

	private Object data;

	private String message;
	
	
	private Integer totalRecords;
	
	
	 public ResponseHandler() {
	    }

	    public ResponseHandler(Boolean status, Object data, String message) {
	        this.status = status;
	        this.data = data;
	        this.message = message;
	    }

	    public Boolean getStatus() {
	        return status != null ? status : false;
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

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }



	    public Integer getTotalRecords() {
	        return totalRecords;
	    }

	    public void setTotalRecords(Integer totalRecords) {
	        this.totalRecords = totalRecords;
	    }

	

}
