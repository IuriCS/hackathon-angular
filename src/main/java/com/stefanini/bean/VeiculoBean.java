package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Modelo;
import com.stefanini.model.Proprietario;
import com.stefanini.model.Veiculo;
import com.stefanini.service.ModeloService;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.VeiculoService;

@Named
@SessionScoped
public class VeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private VeiculoService veiculoService;
	@Inject
	private ProprietarioService proprietarioService;
	@Inject
	private ModeloService modeloService;
	private List<Veiculo> veiculos;
	private List<Proprietario> proprietarios = new ArrayList<>();
	private List<Modelo> modelos = new ArrayList<>();
	@Inject
	private Veiculo veiculo;
	private Long idProprietario;
	private Long idModelo;

	@PostConstruct
	public void init() {
		if (proprietarios.isEmpty()) {
			proprietarios = proprietarioService.todos();
		}

		if (modelos.isEmpty()) {
			modelos = modeloService.todos();
		}
	}

	public Modelo procuraModelo(Long id) {
		for (Modelo m : modelos) {
			if (m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}

	public Proprietario procuraProprietario(Long id) {
		for (Proprietario p : proprietarios) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public void salva() {
		Modelo m = procuraModelo(idModelo);
		Proprietario p = procuraProprietario(idProprietario);
		veiculo.setProprietario(p);
		veiculo.setModelo(m);
		veiculoService.incluir(veiculo);

		limparFormulario();
	}

	private void limparFormulario() {
		veiculo = new Veiculo();
		veiculos = null;
	}

	public List<Veiculo> getVeiculos() {
		if (veiculos == null) {
			veiculos = veiculoService.todos();
		}
		return veiculos;
	}

	public List<Proprietario> getProprietarios() {
		return proprietarios;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public Long getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Long idProprietario) {
		this.idProprietario = idProprietario;
	}

	public Long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
