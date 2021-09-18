package com.src.jpa.sample.repositories.custom.impl.query;

public enum InstructorQuery {

	DEPARTMENT("department");

	public static final String INTRUCTOR_BY_DEPARTMENT = "INTRUCTOR_BY_DEPARTMENT";

	private final String attribute;

	InstructorQuery(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return attribute;
	}
}
