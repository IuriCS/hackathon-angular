package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.LocalInfracao;
import com.stefanini.repository.LocalInfracaoRepository;

@Stateless
public class LocalInfracaoService {

	@Inject
	private LocalInfracaoRepository localRepositorio;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(LocalInfracao local) {
		localRepositorio.incluir(local);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<LocalInfracao> lista() {
		return localRepositorio.lista();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public LocalInfracao buscar(Integer id) {
		return localRepositorio.busca(id);
	}
}
