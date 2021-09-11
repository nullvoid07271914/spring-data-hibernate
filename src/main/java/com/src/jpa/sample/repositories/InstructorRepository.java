package com.src.jpa.sample.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.jpa.sample.entities.Instructor;
import com.src.jpa.sample.repositories.base.PersistentRepository;
import com.src.jpa.sample.repositories.custom.InstructorRepositoryCustom;

@Repository
public interface InstructorRepository extends PersistentRepository<Instructor, Long>, InstructorRepositoryCustom {

	@Modifying
	@Transactional
	@Query("UPDATE Instructor e SET e.firstname = :prefix || e.firstname WHERE e.id = :instructorId")
	public void appendPrefixToFirstName(@Param("instructorId") Long instructorId, @Param("prefix") String prefix);

	@Query("SELECT e from Instructor e WHERE LOWER(e.email) LIKE %:email%")
	public Instructor findInstructorByEmail(@Param("email") String email);

	@Query("SELECT e from Instructor e WHERE e.mobileNumber LIKE :mobileNumber")
	public Instructor findInstructorByMobileNumber(@Param("mobileNumber") String mobileNumber);
}
