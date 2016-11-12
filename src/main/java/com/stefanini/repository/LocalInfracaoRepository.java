package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.LocalInfracao;

public class LocalInfracaoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(LocalInfracao local) {
		this.manager.persist(local);
	}

	public void altera(LocalInfracao local) {
		this.manager.merge(local);
	}

	public LocalInfracao busca(Integer id) {
		return this.manager.find(LocalInfracao.class, id);
	}

	public List<LocalInfracao> lista() {
		return this.manager.createQuery("select l from LocalInfracao l", LocalInfracao.class).getResultList();
	}

}
