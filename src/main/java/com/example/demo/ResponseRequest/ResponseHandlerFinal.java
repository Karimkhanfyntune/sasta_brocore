package com.example.demo.ResponseRequest;

import java.io.Serializable;

import com.example.demo.Enum.Errortype;

public class ResponseHandlerFinal implements Serializable{
	private Boolean status;

	private Object data;

	private String message;
	
	private  Errortype errortype;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Errortype getErrortype() {
		return errortype;
	}

	public void setErrortype(Errortype errortype) {
		this.errortype = errortype;
	}	

}
