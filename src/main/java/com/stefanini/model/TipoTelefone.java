package com.stefanini.model;

public enum TipoTelefone {

	CELULAR("Celular"), 
	TELEFONE("Telefone");

	private String descricao;

	private TipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
