package com.stefanini.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Sexo;
import com.stefanini.model.Telefone;
import com.stefanini.model.TipoTelefone;
import com.stefanini.service.ProprietarioService;
import com.stefanini.util.jsf.FacesUtil;

@Named
@SessionScoped
public class ProprietarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProprietarioService proprietarioService;
	@Inject
	private Proprietario proprietario;
	private Proprietario proprietarioSelecionado;
	private List<Proprietario> proprietarios;
	@Inject
	private Telefone telefone;

	@PostConstruct
	public void init() {
		proprietarios = proprietarioService.todos();
	}

	public String novoProprietario() {
		proprietario = new Proprietario();

		return "cadastro-proprietario?faces-redirect=true";
	}

	public String salvar() {
		try {
			proprietarioService.incluir(proprietario);
			FacesUtil.adicionarMensagemInfo("Proprietário " + proprietario.getNome() + " cadastrado com sucesso!");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemErro(e.getMessage());
		}
		
		limparFormulario();

		return "lista-proprietario?faces-redirect=true";
	}

	public void salvarTelefone() {
		if (this.proprietario != null) {
			this.proprietario.adicionarTelefone(telefone);
			this.telefone = new Telefone();
		}
	}
	
	public void excluir(){
		try {
			proprietarioService.remover(proprietarioSelecionado);
			FacesUtil.adicionarMensagemInfo("Proprietario " + proprietarioSelecionado.getNome() + " excluído com sucesso!");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemErro(e.getMessage());
		}
		
		limparFormulario();
	}
	
	public void buscarProprietarioComTelefone(){
		proprietarioSelecionado = this.proprietarioService.comTelefone(proprietarioSelecionado.getId());
	}
	
	private void limparFormulario() {
		proprietario = new Proprietario();
		proprietarios = null;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Proprietario getProprietarioSelecionado() {
		return proprietarioSelecionado;
	}

	public void setProprietarioSelecionado(Proprietario proprietarioSelecionado) {
		this.proprietarioSelecionado = proprietarioSelecionado;
	}

	public List<Proprietario> getProprietarios() {
		if(proprietarios == null){
			proprietarios = proprietarioService.todos();
		}
		return proprietarios;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Sexo> getSexos() {
		return Arrays.asList(Sexo.values());
	}

	public List<TipoTelefone> getTipoTelefone() {
		return Arrays.asList(TipoTelefone.values());
	}

}
