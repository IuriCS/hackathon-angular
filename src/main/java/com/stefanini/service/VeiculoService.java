package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Veiculo;
import com.stefanini.repository.VeiculoRepository;

@Stateless
public class VeiculoService {

	@Inject
	private VeiculoRepository veiculoRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Veiculo veiculo) {
		veiculoRepository.incluir(veiculo);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Veiculo> todos() {
		return this.veiculoRepository.todos();
	}

}
