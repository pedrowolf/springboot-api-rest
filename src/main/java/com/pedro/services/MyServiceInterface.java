package com.pedro.services;

import java.util.List;

public interface MyServiceInterface<Entidade, ID> {

	Entidade saveOrUpdate(Entidade entidade);
	
	List<?> loadAll();
	
	Entidade loadById(ID id);
	
	void deleteById(ID id);
}
