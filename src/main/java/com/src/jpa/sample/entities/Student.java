package com.src.jpa.sample.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_TBL")
public class Student extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID", updatable = false, nullable = false, unique = true)
	private Long id;

	@Column(name = "COURSE")
	private String course;

	@Column(name = "DEPARTMENT")
	private String department;

	@Column(name = "LEVEL")
	private int level;

	@ElementCollection
	@CollectionTable(name = "ADDRESS_TBL", joinColumns = @JoinColumn(name = "ID", referencedColumnName = "STUDENT_ID"))
	private List<Address> address;

	@ElementCollection
	@CollectionTable(name = "STUDENT_OFFICER_TBL", joinColumns = @JoinColumn(name = "ID", referencedColumnName = "STUDENT_ID"))
	@MapKeyColumn(name = "TYPE") // key
	@Column(name = "POSITION") // value
	private Map<String, String> position;

	@OneToMany(targetEntity = Subject.class)
	@JoinTable(name = "STUDENT_SUBJECT_TBL", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SUBJECT_ID") })
	private List<Subject> subjects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Map<String, String> getPosition() {
		return position;
	}

	public void setPosition(Map<String, String> position) {
		this.position = position;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}
