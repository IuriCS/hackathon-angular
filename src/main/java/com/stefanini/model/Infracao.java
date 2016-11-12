package com.stefanini.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "infracoes")
public class Infracao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "Idagente")
	private Agente agente;
	@ManyToOne
	@JoinColumn(name = "IdLocalInfracao")
	private LocalInfracao local;
	@ManyToOne
	@JoinColumn(name = "IdTipoInfracao")
	private TipoInfracao tipo;
	@ManyToOne
	@JoinColumn(name = "IdVeiculo")
	private Veiculo veiculo;
	private int velocidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public LocalInfracao getLocal() {
		return local;
	}

	public void setLocal(LocalInfracao local) {
		this.local = local;
	}

	public TipoInfracao getTipo() {
		return tipo;
	}

	public void setTipo(TipoInfracao tipo) {
		this.tipo = tipo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

}