package com.src.jpa.sample.entities.testing;

import java.io.Serializable;

import com.src.jpa.sample.entities.Instructor;

/*
 * This test package demonstrate only the mapping
 * of student and instructor entity
 * 
 * */

//@Entity
//@Table(name = "STUDENT_TBL")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue
//	@Column(name = "STUDENT_ID")
	private Long id;

//	@Column(name = "COURSE")
	private String course;

//	@Column(name = "LEVEL")
	private int level;

//	@Column(name = "DEPARTMENT")
	private String department;

	/*
	 * By default, @ManyToOne associations use the FetchType.EAGER strategy, which
	 * can lead to N+1 query issues (duplicate saving) or fetching more data than
	 * necessary.
	 */
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "INSTRUCTOR_ID")
	private Instructor instructor;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
