package br.com.home.help.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.dozer.Mapper;

import br.com.home.help.EspecialidadeService;
import br.com.home.help.core.entidades.UsuarioEspecialidade;
import br.com.home.help.dto.UsuarioEspecialidadeDTO;

@Named
@Path("especialidade")
public class EspecialidadeResource extends AbstractResource {

	@Inject
	private EspecialidadeService especialidadeService;

	@Inject
	public EspecialidadeResource(Mapper mapper) {
		super.mapper = mapper;
	}

	// http://localhost:8080/homehelp/rest/especialidade/cano
	//http://www.portalandroid.org/comunidade/viewtopic.php?f=7&t=17465
	@GET
	public List<UsuarioEspecialidadeDTO> especialidades(@QueryParam("especialidade") String especialidade) {

		List<UsuarioEspecialidade> lst = especialidadeService.listar(especialidade);

		List<UsuarioEspecialidadeDTO> retorno = super.mapList(lst, UsuarioEspecialidadeDTO.class);

		return retorno;
	}

}