package com.src.jpa.sample.repositories.custom;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.src.jpa.sample.entities.Instructor;

public interface InstructorRepositoryCustom {

	public Instructor findByDepartment(Map<String, Object> params) throws IOException;

	public List<Instructor> findByDepartments(Set<String> departments);
}
