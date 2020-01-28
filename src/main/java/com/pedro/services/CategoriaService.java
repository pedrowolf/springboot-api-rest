package com.pedro.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pedro.domain.Categoria;
import com.pedro.dto.CategoriaDTO;
import com.pedro.exceptions.DataIntegrityException;
import com.pedro.exceptions.ObjectNotFoundException;
import com.pedro.repositories.CategoriaRepository;

@Service
public class CategoriaService implements MyServiceInterface<Categoria, Long> {

	@Autowired
	private CategoriaRepository repo;

	@Override
	public Categoria saveOrUpdate(Categoria entidade) {
		// TODO Auto-generated method stub
		if (entidade.getId() != null) {
			entidade.setVersion(loadById(entidade.getId()).getVersion());
		}
		return repo.save(entidade);
	}

	@Override
	public List<CategoriaDTO> loadAll() {
		// TODO Auto-generated method stub
		return repo.findAll().stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String orderDirection) {
		PageRequest pageReq = PageRequest.of(page, linesPerPage, Direction.valueOf(orderDirection), orderBy);
		return repo.findAll(pageReq);
	}

	@Override
	public Categoria loadById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: Categoria"));
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		if (loadById(id).getProdutos().isEmpty()) {
			repo.deleteById(id);
		} else {
			throw new DataIntegrityException(
					"O Objeto possui relacionamento no banco de dados, o que impossibilita sua remoção!");
		}
	}

	public Categoria fromDTO(CategoriaDTO dto) {
		Categoria c = new Categoria();
		c.setId(dto.getId());
		c.setNome(dto.getNome());
		return c;
	}
}
