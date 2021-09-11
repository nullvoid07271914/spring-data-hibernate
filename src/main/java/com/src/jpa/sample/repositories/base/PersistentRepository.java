package com.src.jpa.sample.repositories.base;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean // @NoRepositoryBean - repository to remain generic
public interface PersistentRepository<T, ID extends Serializable>
		extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

	public List<T> findDomainByDateSaved(LocalDate dateSaved);
}
