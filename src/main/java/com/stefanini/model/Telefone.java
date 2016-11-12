package com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefones")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TelefonePK id = new TelefonePK();
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private TipoTelefone tipo;
	@ManyToOne
	@JoinColumn(name = "IdProprietario")
	private Proprietario proprietario;

	public TelefonePK getId() {
		return this.id;
	}

	public void setId(TelefonePK id) {
		this.id = id;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}