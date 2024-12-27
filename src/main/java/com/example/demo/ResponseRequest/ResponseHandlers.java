package com.example.demo.ResponseRequest;

import java.util.Map;

import com.example.demo.Enum.Errortype;
import com.example.demo.Enum.ModuleListingEnum;

public class ResponseHandlers {
	
	private Boolean status;

	private Object data;

	private String message;
	
	private  Errortype errortype;
	
	private Integer totalRecord;

    private ModuleListingEnum moduleName; 
	
	public Boolean getStatus() {
		return status;
	}

	public ModuleListingEnum getModuleName() {
		return moduleName;
	}

	public void setModuleName(ModuleListingEnum moduleName) {
		this.moduleName = moduleName;
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

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	
	

}
