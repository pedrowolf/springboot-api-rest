package com.pedro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.domain.Produto;
import com.pedro.repositories.ProdutoRepository;

@Service
public class ProdutoService implements MyServiceInterface<Produto, Long> {

	@Autowired
	private ProdutoRepository repo;
	
	@Override
	public Produto saveOrUpdate(Produto entidade) {
		// TODO Auto-generated method stub
		return repo.save(entidade);
	}

	@Override
	public List<Produto> loadAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Produto loadById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
