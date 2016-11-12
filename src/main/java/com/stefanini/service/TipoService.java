package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.TipoInfracao;
import com.stefanini.repository.TipoInfracaoRepository;

@Stateless
public class TipoService {

	@Inject
	private TipoInfracaoRepository tipoRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(TipoInfracao tipoInfracao) {
		tipoRepository.incluir(tipoInfracao);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<TipoInfracao> lista() {
		return tipoRepository.lista();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TipoInfracao buscar(Integer id) {
		return tipoRepository.busca(id);
	}

}
