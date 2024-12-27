package com.example.demo.Enum;

public enum Gender {
	MALE("Male"),
	FEMALE("Female"),
	OTHER("Other"),
	OTHERS("Others"),
	Male("Male"),
	Female("Female"),
	Others("Others");

	private final String label;

	Gender(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}