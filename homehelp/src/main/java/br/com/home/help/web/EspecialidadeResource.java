package br.com.home.help.web;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.home.help.EspecialidadeService;
import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.dto.EspecialidadeDTO;

@Path("especialidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EspecialidadeResource {

	@Inject
	private EspecialidadeService especialidadeResource;

	// http://localhost:8080/homehelp/rest/especialidade
	@GET
	public List<EspecialidadeDTO> hello(String str) {

		List<Especialidade> lst = especialidadeResource.listar(str);

		return null;
	}

}