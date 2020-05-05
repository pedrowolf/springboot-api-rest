package com.pedro.domain;

public enum TipoCliente {

	PF("PF", "Pessoa Física"),
	PJ("PJ", "Pessoa Jurídica");
	
	private String def;
	private String descricao;
	
	TipoCliente(String def, String descricao) {
		this.def = def;
		this.descricao = descricao;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
