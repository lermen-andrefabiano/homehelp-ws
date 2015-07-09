package br.com.home.help.web;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.dozer.Mapper;

import br.com.home.help.ChamadoService;
import br.com.home.help.core.enuns.TipoPrioridade;

@Named
@Path("chamado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChamadoResource extends AbstractResource {

	@Inject
	private ChamadoService chamadoService;

	@Inject
	public ChamadoResource(Mapper mapper) {
		super.mapper = mapper;
	}

	@GET
	public void abrir(@QueryParam("observacao") String observacao,
			@QueryParam("descricao") String descricao,
			@QueryParam("prioridade") String prioridade,
			@QueryParam("usuarioId") Long usuarioId,
			@QueryParam("prestadorId") Long prestadorId,
			@QueryParam("especialidadeId") Long especialidadeId) {

		this.chamadoService.abrir(observacao, descricao,
				TipoPrioridade.valueOf(prioridade), usuarioId, prestadorId,
				especialidadeId);

	}

}