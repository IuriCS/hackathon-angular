package com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_infracao")
public class TipoInfracao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descricaoInfracao", length = 50)
	private String descricaoTipoInfracao;
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoTipoInfracao() {
		return this.descricaoTipoInfracao;
	}

	public void setDescricaoTipoInfracao(String descricaoTipoInfracao) {
		this.descricaoTipoInfracao = descricaoTipoInfracao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}