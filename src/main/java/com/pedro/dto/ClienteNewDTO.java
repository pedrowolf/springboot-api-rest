package com.pedro.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.pedro.domain.TipoCliente;
import com.pedro.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO {

	@NotEmpty(message = "Campo nome é obrigatório")
	private String nome;
	
	@NotEmpty(message = "Campo E-mail é obrigatório")
	@Email(message = "Digite um E-mail Válido")
	private String email;
	
	private String cpf;
	
	@NotEmpty(message = "Campo logradouro é obrigatório")
	private String logradouro;
	
	@NotEmpty(message = "Campo CEP é obrigatório")
	private String cep;
	
	@NotEmpty(message = "Campo estado é obrigatório")
	private String estado;
	
	@NotEmpty(message = "Campo cidade é obrigatório")
	private String cidade;
	
	@NotEmpty(message = "Campo telefone é obrigatório")
	private String fone;
	
	@NotNull(message = "Campo tipo é obrigatório")
	private Integer tipo;
	
	public ClienteNewDTO() {
		
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	public Integer getTipo() {
		return tipo;
	}
	
	
}
