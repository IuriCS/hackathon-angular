package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Proprietario;

public class ProprietarioRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Proprietario proprietario) {
		this.manager.persist(proprietario);
	}

	public List<Proprietario> todos() {
		return this.manager.createQuery("from Proprietario", Proprietario.class).getResultList();
	}

	public Proprietario porId(Long id) {
		return this.manager.find(Proprietario.class, id);
	}

	public Proprietario comTelefone(Long id) {
		String jpql = "select p from Proprietario p "
				+ "JOIN p.telefones t "
				+ "where p.id = :id";
		
		return this.manager.createQuery(jpql,
				Proprietario.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	public void excluir(Proprietario proprietario) {
		this.manager.remove(proprietario);
	}

}
