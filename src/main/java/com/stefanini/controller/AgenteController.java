package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;

@Path("/agente")
@RequestScoped
public class AgenteController {

	@Inject
	private AgenteService agenteService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Agente> todos() {
		return agenteService.todos();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void adicionar(Agente agente) {
		try {
			agenteService.incluir(agente);
		} catch (Exception e) {
			System.out.println("Erro! " + e.getMessage());
		}
	}

	@Path("/delete")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void excluir(Agente agente) {
		try {
			agenteService.remover(agente);
		} catch (Exception e) {
			System.out.println("Erro! " + e.getMessage());
		}
	}

	@Path("/alterar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void alterar(Agente agente) {
		agenteService.alterar(agente);
	}

}
