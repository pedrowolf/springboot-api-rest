package com.pedro.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pedro.domain.Cliente;
import com.pedro.dto.ClienteDTO;
import com.pedro.dto.ClienteNewDTO;
import com.pedro.exceptions.ObjectNotFoundException;
import com.pedro.repositories.ClienteRepository;

@Service
public class ClienteService implements MyServiceInterface<Cliente, Long>{

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public Cliente saveOrUpdate(Cliente entidade) {
		// TODO Auto-generated method stub
		if (entidade.getId() != null) {
			entidade.setVersion(loadById(entidade.getId()).getVersion());
		}
		return repo.save(entidade);
	}

	@Override
	public List<ClienteDTO> loadAll() {
		// TODO Auto-generated method stub
		return repo.findAll().stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String orderDirection) {
		PageRequest pageReq = PageRequest.of(page, linesPerPage, Direction.valueOf(orderDirection), orderBy);
		return repo.findAll(pageReq);
	}

	@Override
	public Cliente loadById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: Cliente"));
	}

	@Override
	public void deleteById(Long id) {
			repo.deleteById(id);
	}

	public Cliente fromDTO(ClienteDTO dto) {
		Cliente c = new Cliente();
		c.setId(dto.getId());
		c.setNome(dto.getNome());
		return c;
	}

	public Cliente fromNewDTO(ClienteNewDTO dto) {
		Cliente c = new Cliente();
		c.setNome(dto.getNome());
		c.setCep(dto.getCep());
		c.setCidade(dto.getCidade());
		c.setCpf(dto.getCpf());
		c.setEmail(dto.getEmail());
		c.setEstado(dto.getEstado());
		c.setFone(dto.getFone());
		c.setLogradouro(dto.getLogradouro());
		c.setTipo(dto.getTipo());
		return c;
	}
}
