package com.src.jpa.sample.entities.group;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.src.jpa.sample.entities.Student;
import com.src.jpa.sample.entities.Subject;

@Entity
@Table(name = "STUDENT_SUBJECT_TBL")
public class StudentSubject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false, unique = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
