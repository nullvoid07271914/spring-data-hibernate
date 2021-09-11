package com.src.jpa.sample.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT_TBL")
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUBJECT_ID", updatable = false, nullable = false, unique = true)
	private Long id;

	@Column(name = "SUBJECT_NAME")
	private String name;

	@Column(name = "SUBJECT_DESCRIPTION")
	private String description;

	@Column(name = "SUBJECT_UNIT")
	private int unit;

	@OneToMany(targetEntity = Student.class)
	@JoinTable(name = "STUDENT_SUBJECT_TBL", joinColumns = { @JoinColumn(name = "SUBJECT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "STUDENT_ID") })
	private List<Student> students;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
