package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.TipoInfracao;
import com.stefanini.service.TipoService;

@Named
@RequestScoped
public class TipoInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoInfracao tipo;
	@Inject
	private TipoService service;

	public void cadastrar() {
		service.incluir(tipo);

	}

	public TipoInfracao getTipo() {
		return tipo;
	}

	public void setTipo(TipoInfracao tipo) {
		this.tipo = tipo;
	}

}
