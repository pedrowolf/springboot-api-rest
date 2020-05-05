package com.pedro.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedro.domain.Cliente;
import com.pedro.dto.ClienteDTO;
import com.pedro.dto.ClienteNewDTO;
import com.pedro.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll() {
		return ResponseEntity.ok().body(service.loadAll());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "orderDirection", defaultValue = "ASC") String orderDirection) {
		return ResponseEntity.ok()
				.body(service.findPage(page, linesPerPage, orderBy, orderDirection).map(obj -> new ClienteDTO(obj)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.loadById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody @Valid ClienteNewDTO objDto) {
		Cliente categoria = service.saveOrUpdate(service.fromNewDTO(objDto));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody @Valid ClienteDTO objDto, @PathVariable Long id) {
		objDto.setId(id);
		service.saveOrUpdate(service.fromDTO(objDto));
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		find(id);
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

