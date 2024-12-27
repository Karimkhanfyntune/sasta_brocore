package com.example.demo.Enum;

public enum RegexValiadation {

	AADHAR_REGEX("\\d{12}"), 
	PAN_REGEX("[A-Z]{5}[0-9]{4}[A-Z]{1}"),
	PASSPORT_REGEX("[A-Z]{1}[0-9]{7}"),
    EMAIL_REGEX("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"),
     URL_PATTERN ("^(https?://)?([\\w.-]+(/|\\?\\w+=\\w+(&\\w+=\\w+)*)*)?$");

//	UCC_REGEX("[A-Z]+[0-9]+");
	   public boolean matches(String input) {
	        return input != null && input.matches(regex);
	    }
	
	private final String regex;

	private RegexValiadation(String regex) {
		this.regex = regex;
	}

	public String getRegex() {
		return regex;
	}

}
