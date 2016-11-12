package com.stefanini.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Categoria;
import com.stefanini.model.Modelo;
import com.stefanini.service.ModeloService;

@Named
@SessionScoped
public class ModeloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloService modeloService;
	@Inject
	private Modelo modelo;
	private List<Modelo> modelos;

	@PostConstruct
	public void init() {
		modelos = modeloService.todos();
	}

	public void salva() {
		modeloService.incluir(modelo);
		limparFormulario();
	}

	private void limparFormulario() {
		modelo = new Modelo();
		modelos = null;
	}

	public List<Modelo> getModelos() {
		if (modelos == null) {
			modelos = modeloService.todos();
		}
		return modelos;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Categoria> getCategorias() {
		return Arrays.asList(Categoria.values());
	}

}
