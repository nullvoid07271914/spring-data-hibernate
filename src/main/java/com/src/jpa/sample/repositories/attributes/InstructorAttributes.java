package com.src.jpa.sample.repositories.attributes;

public enum InstructorAttributes {

	DEPARTMENT("department");

	private final String key;

	InstructorAttributes(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
