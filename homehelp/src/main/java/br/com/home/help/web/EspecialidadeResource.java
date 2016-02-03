package br.com.home.help.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.dozer.Mapper;

import br.com.home.help.UsuarioEspecialidadeService;
import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.UsuarioEspecialidade;
import br.com.home.help.dto.EspecialidadeDTO;
import br.com.home.help.dto.UsuarioEspecialidadeDTO;

@Named
@Path("especialidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EspecialidadeResource extends AbstractResource {

	@Inject
	private UsuarioEspecialidadeService usuarioEspecialidadeService;

	@Inject
	public EspecialidadeResource(Mapper mapper) {
		super.mapper = mapper;
	}
	
	@GET	
	@Path("getUsuarioEspecialidades")
	public List<UsuarioEspecialidadeDTO> getUsuarioEspecialidades(@QueryParam("especialidade") String especialidade) {		
		List<UsuarioEspecialidade> lst = usuarioEspecialidadeService.getUsuarioEspecialidades(especialidade);		

		List<UsuarioEspecialidadeDTO> retorno = super.mapList(lst, UsuarioEspecialidadeDTO.class);

		return retorno;
	}
	
	@GET
	@Path("getEspecialidaPrestador")
	public List<UsuarioEspecialidadeDTO> getEspecialidaPrestador(@QueryParam("prestadorId") Long prestadorId) {		
		List<UsuarioEspecialidade> lst = usuarioEspecialidadeService.getEspecialidaPrestador(prestadorId);	

		List<UsuarioEspecialidadeDTO> retorno = super.mapList(lst, UsuarioEspecialidadeDTO.class);

		return retorno;
	}
	
	@GET	
	@Path("getEspecialidades")
	public List<EspecialidadeDTO> getEspecialidades(@QueryParam("especialidade") String especialidade) {		
		List<Especialidade> lst = usuarioEspecialidadeService.getEspecialidades(especialidade);		

		List<EspecialidadeDTO> retorno = super.mapList(lst, EspecialidadeDTO.class);

		return retorno;
	}
	
	@GET
	@Path("excluir")
	public Response excluir(@QueryParam("usuarioEspecialidadeId") Long usuarioEspecialidadeId) {		
		this.usuarioEspecialidadeService.excluir(usuarioEspecialidadeId);
		return Response.ok(true).build();
	}
	
	@POST
	@Path("incluir")
	public Response incluir(@QueryParam("usuarioId") Long usuarioId, @QueryParam("especialidadeId") Long especialidadeId, 
			@QueryParam("valorCobrado") Long valorCobrado) {		
		this.usuarioEspecialidadeService.incluir(usuarioId, especialidadeId, valorCobrado);
		return Response.ok(true).build();
	}

}