package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Agente;
import com.stefanini.repository.AgenteRepository;

@Stateless
public class AgenteService {

	@Inject
	private AgenteRepository agenteRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Agente agente) throws Exception {

		if (agente.getNome() == null || "".equals(agente.getNome().trim()) || agente.getDataContratacao() == null) {
			throw new Exception("Nome ou data de contratação obrigatórios");
		}

		agenteRepository.incluir(agente);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Agente porId(Long id) {
		return this.agenteRepository.porId(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Agente agente) throws Exception {
		try {
			agente = porId(agente.getId());
			if (agente != null) {
				this.agenteRepository.excluir(agente);
			}
		} catch (Exception e) {
			throw new Exception("Agente não pode ser excluído!");
		}
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Agente> todos() {
		return this.agenteRepository.todos();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void alterar(Agente agente){
		this.agenteRepository.alterar(agente);
	}

}
