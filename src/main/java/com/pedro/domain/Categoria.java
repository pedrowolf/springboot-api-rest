package com.pedro.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;


@Entity
public class Categoria extends GenericDomain{

	private static final long serialVersionUID = 1L;

	private String nome;

	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
}
