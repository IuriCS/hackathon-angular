package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.LocalInfracao;
import com.stefanini.service.LocalInfracaoService;

@Named
@RequestScoped
public class LocalInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LocalInfracaoService service;
	@Inject
	private LocalInfracao local;

	public void cadastrar() {
		service.incluir(local);
	}

	public LocalInfracao getLocal() {
		return local;
	}

	public void setLocal(LocalInfracao local) {
		this.local = local;
	}

}
