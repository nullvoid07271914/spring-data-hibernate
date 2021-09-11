package com.src.jpa.sample.repositories.custom;

import java.util.List;
import java.util.Set;

import com.src.jpa.sample.entities.Instructor;

public interface InstructorRepositoryCustom {

	public List<Instructor> findByDepartments(Set<String> departments);
}
