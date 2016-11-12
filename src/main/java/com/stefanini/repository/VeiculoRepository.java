package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Veiculo;

public class VeiculoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Veiculo veiculo) {
		this.manager.persist(veiculo);
	}

	public List<Veiculo> todos() {
		return this.manager.createQuery("from Veiculo", Veiculo.class).getResultList();
	}

}
