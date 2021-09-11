package com.src.jpa.sample.repositories.base.impl;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.src.jpa.sample.repositories.base.PersistentRepository;

public class ExtendedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements PersistentRepository<T, ID> {

	private final JpaEntityInformation<T, ?> entityInformation;

	private final EntityManager entityManager;

	public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<T> findDomainByDateSaved(LocalDate dateSaved) {
		Class<T> domainClassType = entityInformation.getJavaType();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(domainClassType);
		Root<T> root = query.from(domainClassType);

		Predicate whereDateSaved = builder.equal(root.<String>get("date_saved"), 1);
		query.select(root).where(whereDateSaved);

		TypedQuery<T> typedQuery = entityManager.createQuery(query);
		return typedQuery.getResultList();
	}

//	@Transactional
//	@Override
//	public List<T> findEntitiesBetweenDateSaved(LocalDate from, LocalDate to) {
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<T> query = builder.createQuery(getDomainClass());
//		Root<T> root = query.from(getDomainClass());
//
//		Predicate whereDateFrom = builder.equal(root.<Date>get(DATE_SAVED), from);
//		Predicate whereDateTo = builder.equal(root.<Date>get(DATE_SAVED), to);
//		query.select(root).where(whereDateFrom, whereDateTo);
//
//		TypedQuery<T> typedQuery = entityManager.createQuery(query);
//		return typedQuery.getResultList();
//	}

//	public List<T> findEntitiesByContainText(String attribute, String text) {
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<T> criteria = builder.createQuery(getDomainClass());
//		Root<T> root = criteria.from(getDomainClass());
//
//		Predicate predicate = builder.like(root.<String>get(attribute), "%" + text + "%");
//		criteria.select(root).where(predicate);
//		TypedQuery<T> query = entityManager.createQuery(criteria);
//		return query.getResultList();
//	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<T> findEntitiesByIds(ID... id) {
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<T> criteria = builder.createQuery(getDomainClass());
//		Root<T> root = criteria.from(getDomainClass());
//
//		String idAttribute = entityInformation.getIdAttribute().getName();
//		In<ID> inClause = builder.in(root.get(idAttribute));
//		for (ID i : id) {
//			inClause.value(i);
//		}
//
//		criteria.select(root).where(inClause);
//		TypedQuery<T> query = entityManager.createQuery(criteria);
//		return query.getResultList();
//	}

//public List<T> findByActive() {
//	Class<T> entityClassType = entityInformation.getJavaType();
//	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//	CriteriaQuery<T> query = builder.createQuery(entityClassType);
//	Root<T> root = query.from(entityClassType);
//
//	Predicate whereActiveEmployees = builder.equal(root.<String>get("active"), 1);
//	query.select(root).where(whereActiveEmployees);
//	TypedQuery<T> typedQuery = entityManager.createQuery(query);
//	return typedQuery.getResultList();
//}
//

//
//@SuppressWarnings("unchecked")
//public T findByParams(Map<String, Object> params, String filter) {
//	/* "name = :name" -> filter */
//	final String jpql = "FROM " + entityInformation.getEntityName() + " WHERE " + filter;
//
//	Query query = entityManager.createQuery(jpql);
//	for (Map.Entry<String, Object> value : params.entrySet())
//		query.setParameter(value.getKey(), value.getValue());
//
//	return (T) query.getSingleResult();
//}
//
}
