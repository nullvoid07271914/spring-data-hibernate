package com.src.jpa.sample.repositories.custom.impl;

import static com.src.jpa.sample.repositories.custom.impl.query.InstructorQuery.DEPARTMENT;
import static com.src.jpa.sample.repositories.custom.impl.query.InstructorQuery.INTRUCTOR_BY_DEPARTMENT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
import com.src.jpa.sample.repositories.custom.InstructorRepositoryCustom;
import com.src.jpa.sample.repositories.custom.impl.query.SqlQuery;

@Repository
public class InstructorRepositoryCustomImpl implements InstructorRepositoryCustom {

	private static Logger logger = LoggerFactory.getLogger(InstructorRepositoryCustomImpl.class);

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private SqlQuery sqlQuery;

	@Transactional
	@Override
	public Instructor findByDepartment(Map<String, Object> params) throws IOException {
		String sql = sqlQuery.getSql(INTRUCTOR_BY_DEPARTMENT);
		TypedQuery<Instructor> query = entityManager.createQuery(sql, Instructor.class);
		
		for (Map.Entry<String, Object> param : params.entrySet()) {
			String attribute = param.getKey();
			Object value = param.getValue();
			query.setParameter(attribute, value);
		}
		
		return query.getSingleResult();
	}

	@Transactional
	@Override
	public List<Instructor> findByDepartments(Set<String> departments) {
		Class<Instructor> clzz = Instructor.class;
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Instructor> query = criteria.createQuery(clzz);
		Root<Instructor> instructor = query.from(clzz);

		String byDepartment = DEPARTMENT.getAttribute();
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
