package com.example.demo.ResponseRequest;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Enum.Errortype;
import com.example.demo.Enum.ModuleListingEnum;

public class ResponseHandlerWithColumnHead {

	 private Integer totalRecords;
	    private Boolean status;
	    private Errortype errortype;
	    private ModuleListingEnum moduleName; 
	    private Object data;
	    private String message;

	    public ResponseHandlerWithColumnHead() {
	    }


	    public <E> ResponseHandlerWithColumnHead(boolean status, ArrayList<E> data, String message, ModuleListingEnum moduleName) {
	        this.status = status;
	        this.data = data;
	        this.message = message;
	        this.moduleName = moduleName; 
	    }

	    public Integer getTotalRecords() {
	        return totalRecords;
	    }

	    public void setTotalRecords(Integer totalRecords) {
	        this.totalRecords = totalRecords;
	    }

	    public Boolean getStatus() {
	        return status != null ? status : false;
	    }

	    public void setStatus(Boolean status) {
	        this.status = status;
	    }

	    public Errortype getErrortype() {
	        return errortype;
	    }

	    public void setErrortype(Errortype errortype) {
	        this.errortype = errortype;
	    }

	    public ModuleListingEnum getModuleName() {
	        return moduleName;
	    }

	    public void setModuleName(ModuleListingEnum moduleName) {
	        this.moduleName = moduleName;
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

	}


