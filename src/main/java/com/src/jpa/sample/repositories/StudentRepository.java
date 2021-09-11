package com.src.jpa.sample.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.src.jpa.sample.entities.Student;
import com.src.jpa.sample.repositories.base.PersistentRepository;

@Repository
public interface StudentRepository extends PersistentRepository<Student, Long> {

	@Modifying
	@Query("UPDATE Student s SET s.firstname = :prefix || s.firstname WHERE s.id = :studentId")
	public void appendPrefixToFirstName(@Param("studentId") Long studentId, @Param("prefix") String prefix);

	@Query("SELECT s from Student s WHERE LOWER(s.email) LIKE %:email%")
	public Optional<Student> findStudentByEmail(@Param("email") String email);

	@Query("SELECT s from Student s WHERE s.mobileNumber LIKE :mobileNumber")
	public Optional<Student> findStudentByMobileNumber(@Param("mobileNumber") String mobileNumber);
}
