package br.com.home.help.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.dozer.Mapper;

import br.com.home.help.UsuarioEspecialidadeService;
import br.com.home.help.core.entidades.UsuarioEspecialidade;
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

	//http://localhost:8080/homehelp/rest/especialidade?especialidade=a
	//http://www.portalandroid.org/comunidade/viewtopic.php?f=7&t=17465
	@GET	
	@Path("get")
	public List<UsuarioEspecialidadeDTO> especialidades(@QueryParam("especialidade") String especialidade) {		
		List<UsuarioEspecialidade> lst = usuarioEspecialidadeService.listar(especialidade);		

		List<UsuarioEspecialidadeDTO> retorno = super.mapList(lst, UsuarioEspecialidadeDTO.class);

		return retorno;
	}
	
	@GET
	@Path("listarPorPrestador")
	public List<UsuarioEspecialidadeDTO> listarPorPrestador(@QueryParam("prestadorId") Long prestadorId) {		
		List<UsuarioEspecialidade> lst = usuarioEspecialidadeService.listarPorPrestador(prestadorId);	

		List<UsuarioEspecialidadeDTO> retorno = super.mapList(lst, UsuarioEspecialidadeDTO.class);

		return retorno;
	}
	
	@GET
	@Path("excluir")
	public Response excluir(@QueryParam("usuarioEspecialidadeId") Long usuarioEspecialidadeId) {		
		this.usuarioEspecialidadeService.excluir(usuarioEspecialidadeId);
		
		ResponseBuilder response = Response.ok();

		return response.build();
	}

}