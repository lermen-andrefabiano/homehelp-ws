package br.com.home.help.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.dozer.Mapper;

import br.com.home.help.ChamadoService;
import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.core.enuns.TipoNota;
import br.com.home.help.core.enuns.TipoPrioridade;
import br.com.home.help.dto.ChamadoDTO;
import br.com.home.help.dto.ClassificacaoDTO;
import br.com.home.help.dto.InformacaoAbrirDTO;
import br.com.home.help.dto.InformacaoClassificarDTO;
import br.com.home.help.dto.InformacaoNotificarDTO;

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

	@POST
	@Path("abrir")
	public void abrir(@QueryParam("usuarioId") Long usuarioId,
			@QueryParam("prestadorId") Long prestadorId,
			@QueryParam("especialidadeId") Long especialidadeId,
			@QueryParam("prioridade") String prioridade, InformacaoAbrirDTO info) {

		log.info(info.getDescricao());
		log.info(info.getObservacao());

		this.chamadoService.abrir(info.getObservacao(), info.getDescricao(),
				TipoPrioridade.valueOf(prioridade), usuarioId, prestadorId,
				especialidadeId);

	}

	@GET
	@Path("aberto")
	public List<ChamadoDTO> aberto(@QueryParam("usuarioId") Long usuarioId) {
		List<Chamado> lst = this.chamadoService
				.listarChamadosAbertos(usuarioId);
		lst.add(new Chamado());

		List<ChamadoDTO> retorno = super.mapList(lst, ChamadoDTO.class);

		return retorno;
	}

	@GET
	@Path("classificacao")
	public List<ClassificacaoDTO> classificacao(
			@QueryParam("usuarioId") Long usuarioId) {
		List<Chamado> lst = this.chamadoService.listarPorUsuario(usuarioId);
		lst.add(new Chamado());

		List<ClassificacaoDTO> retorno = super.mapList(lst,
				ClassificacaoDTO.class);

		return retorno;
	}

	@POST
	@Path("notificar")
	public void notificar(@QueryParam("chamadoId") Long chamadoId,
			InformacaoNotificarDTO info) {
		this.chamadoService.notificar(chamadoId, info.getAgendamento(),
				info.getObservacao());
	}

	@POST
	@Path("classificar")
	public void classificar(@QueryParam("nota") String nota,
			@QueryParam("chamadoId") Long chamadoId,
			InformacaoClassificarDTO info) {
		this.chamadoService.classificar(TipoNota.valueOf(nota),
				info.getRecomendacao(), chamadoId);
	}

}