package com.src.jpa.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.src.jpa.sample.entities.group.StudentSubject;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {

}
