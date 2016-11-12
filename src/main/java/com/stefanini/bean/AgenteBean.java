package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;
import com.stefanini.util.jsf.FacesUtil;

@Named
@SessionScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgenteService agenteService;
	@Inject
	private Agente agente;
	private Agente agenteSelecionado;
	private List<Agente> listaAgentes;

	@PostConstruct
	public void init() {
		listaAgentes = agenteService.todos();
	}

	public String novoAgente() {
		agente = new Agente();
		return "cadastro-agente";
	}

	public void salva() {
		try {
			agenteService.incluir(agente);
			FacesUtil.adicionarMensagemInfo("Agente " + agente.getNome() + " cadastrado com sucesso!");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemErro(e.getMessage());
		}
		
		limparFormulario();
	}
	
	public void excluir(){
		try {
			agenteService.remover(agenteSelecionado);
			FacesUtil.adicionarMensagemInfo("Agente " + agenteSelecionado.getNome() + " excluído com sucesso!");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemErro(e.getMessage());
		}
		
		limparFormulario();
	}

	private void limparFormulario() {
		agente = new Agente();
		listaAgentes = null;
	}

	public List<Agente> getAgentes() {
		if (listaAgentes == null) {
			listaAgentes = agenteService.todos();
		}
		return listaAgentes;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Agente getAgenteSelecionado() {
		return agenteSelecionado;
	}

	public void setAgenteSelecionado(Agente agenteSelecionado) {
		this.agenteSelecionado = agenteSelecionado;
	}

}
