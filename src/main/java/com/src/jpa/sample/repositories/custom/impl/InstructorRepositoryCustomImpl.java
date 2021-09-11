package com.src.jpa.sample.repositories.custom.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.jpa.sample.entities.Instructor;
import com.src.jpa.sample.repositories.attributes.InstructorAttributes;
import com.src.jpa.sample.repositories.custom.InstructorRepositoryCustom;

@Repository
public class InstructorRepositoryCustomImpl implements InstructorRepositoryCustom {

	private static Logger logger = LoggerFactory.getLogger(InstructorRepositoryCustomImpl.class);

	@Autowired
	private EntityManager entityManager;

	@Transactional
	@Override
	public List<Instructor> findByDepartments(Set<String> departments) {
		Class<Instructor> clzz = Instructor.class;
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Instructor> query = criteria.createQuery(clzz);
		Root<Instructor> instructor = query.from(clzz);

		String byDepartment = InstructorAttributes.DEPARTMENT.getKey();
		logger.info("Find instructor by departments {}", byDepartment);
		Path<String> emailPath = instructor.get(byDepartment);

		List<Predicate> predicates = new ArrayList<>();
		for (String email : departments) {
			Predicate predicate = criteria.like(emailPath, email);
			predicates.add(predicate);
		}

		Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
		query.select(instructor).where(criteria.or(arrayPredicate));

		return entityManager.createQuery(query).getResultList();
	}

}
