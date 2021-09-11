package com.src.jpa.sample.repositories;

import org.springframework.stereotype.Repository;

import com.src.jpa.sample.entities.Subject;
import com.src.jpa.sample.repositories.base.PersistentRepository;

@Repository
public interface SubjectRepository extends PersistentRepository<Subject, Long> {

}
