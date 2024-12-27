package com.example.demo.implementation;


public class TriggerEventRequest {
	private Integer page;
    private Integer size;
    private String sortBy;
    private String sortOrder;
    private String triggerName;
    private Character isEmail;
    private Character isSms;
    private Character isWhatsapp;
	private String templateAlias;

	
	public String getTemplateAlias() {
		return templateAlias;
	}
	public void setTemplateAlias(String templateAlias) {
		this.templateAlias = templateAlias;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getTriggerName() {
		return triggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public Character getIsEmail() {
		return isEmail;
	}
	public void setIsEmail(Character isEmail) {
		this.isEmail = isEmail;
	}
	public Character getIsSms() {
		return isSms;
	}
	public void setIsSms(Character isSms) {
		this.isSms = isSms;
	}
	public Character getIsWhatsapp() {
		return isWhatsapp;
	}
	public void setIsWhatsapp(Character isWhatsapp) {
		this.isWhatsapp = isWhatsapp;
	}
    
}
