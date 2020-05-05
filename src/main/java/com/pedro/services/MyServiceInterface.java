package com.pedro.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface MyServiceInterface<Entidade, ID> {

	@Transactional
	Entidade saveOrUpdate(Entidade entidade);
	
	List<?> loadAll();
	
	Entidade loadById(ID id);
	
	@Transactional
	void deleteById(ID id);
}
