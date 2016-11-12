package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Agente;

public class AgenteRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Agente agente) {
		this.manager.persist(agente);
	}

	public List<Agente> todos() {
		return this.manager.createQuery("from Agente", Agente.class).getResultList();
	}
	
	public Agente porId(Long id){
		return this.manager.find(Agente.class, id);
	}
	
	public void excluir(Agente agente){
		this.manager.remove(agente);
	}
	
	public void alterar(Agente agente){
		this.manager.merge(agente);
	}

}
