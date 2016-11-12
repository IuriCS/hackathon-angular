package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Proprietario;
import com.stefanini.repository.ProprietarioRepository;

@Stateless
public class ProprietarioService {

	@Inject
	private ProprietarioRepository proprietarioRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Proprietario proprietario) throws Exception {

		if (proprietario.getNome() == null || "".equals(proprietario.getNome().trim()) || 
				proprietario.getCpf() == null || "".equals(proprietario.getCpf().trim())) {
			throw new Exception("Nome ou CPF obrigatórios");
		}

		proprietarioRepository.incluir(proprietario);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Proprietario> todos() {
		return proprietarioRepository.todos();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Proprietario porId(Long id) {
		return this.proprietarioRepository.porId(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Proprietario comTelefone(Long id){
		return this.proprietarioRepository.comTelefone(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Proprietario proprietario) throws Exception {
		try {
			proprietario = porId(proprietario.getId());
			if (proprietario != null) {
				System.out.println(proprietario.getNome());
				this.proprietarioRepository.excluir(proprietario);
			}
		} catch (Exception e) {
			throw new Exception("Proprietario não pode ser excluído!");
		}
	}

}
