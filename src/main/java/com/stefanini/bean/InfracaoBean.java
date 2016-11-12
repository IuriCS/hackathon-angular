package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.model.Infracao;
import com.stefanini.model.LocalInfracao;
import com.stefanini.model.TipoInfracao;
import com.stefanini.model.Veiculo;
import com.stefanini.service.AgenteService;
import com.stefanini.service.InfracaoService;
import com.stefanini.service.LocalInfracaoService;
import com.stefanini.service.TipoService;
import com.stefanini.service.VeiculoService;

@Named
@SessionScoped
public class InfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Infracao infracao;
	@Inject
	private InfracaoService infracaoService;
	@Inject
	private TipoService tipoService;
	@Inject
	private AgenteService agenteService;
	@Inject
	private LocalInfracaoService localService;
	@Inject
	private VeiculoService veiculoService;

	private List<LocalInfracao> locais = new ArrayList<>();
	private List<TipoInfracao> tipos = new ArrayList<>();
	private List<Agente> agentes = new ArrayList<>();
	private List<Infracao> infracoes = new ArrayList<>();
	private List<Veiculo> veiculos = new ArrayList<>();

	private Long agenteId;
	private Long localId;
	private Long tipoId;
	private Long veiculoId;

	@PostConstruct
	public void init() {
		if (this.locais.isEmpty()) {
			locais = localService.lista();
		}

		if (this.tipos.isEmpty()) {
			tipos = tipoService.lista();
		}

		if (this.agentes.isEmpty()) {
			agentes = agenteService.todos();
		}

		if (this.veiculos.isEmpty()) {
			veiculos = veiculoService.todos();
		}
	}

	public List<Agente> completar(String nome) {
		List<Agente> results = new ArrayList<>();
		for (Agente a : agentes) {
			if (a.getNome().toUpperCase().contains(nome.toUpperCase())) {
				results.add(a);
			}
		}
		return results;
	}

	public List<Veiculo> completarVeiculo(String nome) {
		List<Veiculo> results = new ArrayList<>();
		for (Veiculo a : veiculos) {
			if (a.getPlaca() != null && a.getPlaca().toUpperCase().contains(nome.toUpperCase())) {
				results.add(a);
			}
		}
		return results;
	}

	public void cadastrar() {
		Agente agente = getAgente(agenteId);
		LocalInfracao local = getLocal(localId);
		TipoInfracao tipo = getTipo(tipoId);
		Veiculo v = procuraVeiculo(veiculoId);

		infracao.setLocal(local);
		infracao.setTipo(tipo);
		infracao.setAgente(agente);
		infracao.setVeiculo(v);

		infracaoService.incluir(infracao);
	}

	public Long getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(Long agenteId) {
		this.agenteId = agenteId;
	}

	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public Long getTipoId() {
		return tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}

	public Agente getAgente(Long agenteId2) {
		for (Agente a : agentes) {
			if (a.getId().equals(agenteId2)) {
				return a;
			}
		}
		return null;
	}

	public LocalInfracao getLocal(Long id) {
		for (LocalInfracao l : locais) {
			if (l.getId().equals(id)) {
				return l;
			}
		}
		return null;
	}

	public TipoInfracao getTipo(Long id) {
		for (TipoInfracao t : tipos) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	public Veiculo procuraVeiculo(Long id) {
		for (Veiculo v : veiculos) {
			if (v.getId().equals(id)) {
				return v;
			}
		}
		return null;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

	public List<Infracao> getInfracoes() {
		return infracoes;
	}

	public void setInfracoes(List<Infracao> infracoes) {
		this.infracoes = infracoes;
	}

	public List<TipoInfracao> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoInfracao> tipos) {
		this.tipos = tipos;
	}

	public List<LocalInfracao> getLocais() {
		return locais;
	}

	public void setLocais(List<LocalInfracao> locais) {
		this.locais = locais;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

}
