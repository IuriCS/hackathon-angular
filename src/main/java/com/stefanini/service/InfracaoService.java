package com.stefanini.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Infracao;
import com.stefanini.repository.InfracaoRepository;

@Stateless
public class InfracaoService {

	@Inject
	private InfracaoRepository infracaoRepositorio;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Infracao i) {
		infracaoRepositorio.incluir(i);
	}

}
