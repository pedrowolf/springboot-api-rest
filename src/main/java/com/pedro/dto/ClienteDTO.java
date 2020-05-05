package com.pedro.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.pedro.domain.Cliente;
import com.pedro.domain.TipoCliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "Campo nome obrigatório")
	private String nome;
	
	@CPF(message = "Digite um CPF válido")
	private String cpf;
	
	@NotEmpty(message = "Campo email obrigatório")
	@Email(message = "Preencha um email válido")
	private String email;
	
	@NotNull(message = "Campo Tipo de Cliente obrigatório")
	private TipoCliente tipo;
	
	private ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente cli) {
		this.id = cli.getId();
		this.nome = cli.getNome();
		this.email = cli.getEmail();
		this.tipo = cli.getTipo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
}
