package br.com.home.help.web;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dozer.Mapper;

import br.com.home.help.UsuarioService;
import br.com.home.help.core.entidades.Usuario;
import br.com.home.help.dto.LoginDTO;
import br.com.home.help.dto.UsuarioDTO;
import br.com.home.help.util.HomeHelpException;

@Named
@Path("usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource extends AbstractResource {

	@Inject
	private UsuarioService usuarioService;

	@Inject
	public UsuarioResource(Mapper mapper) {
		super.mapper = mapper;
	}
	
	@GET//http://localhost:8080/homehelp/rest/usuario/1
	@Path("{id}")
	public UsuarioDTO obterPorId(@PathParam("id") Long id){
		Usuario u = usuarioService.obterPorId(id);
		
		UsuarioDTO dto = map(u, UsuarioDTO.class);
		
		return dto;
	}

	@POST
	@Path("login")
	public LoginDTO login(LoginDTO login) {
		Usuario u = null;
		try {
			u = usuarioService.login(login.getLogin(), login.getSenha());
			
			login.setSenha(null);
			login.setConfirmaSenha(null);			
			login.setId(u.getId());			
			login.setNome(u.getNome());
			login.setEmail(u.getEmail());
			login.setLogin(u.getLogin());
			login.setEndereco(u.getEndereco());
			login.setPrestaServico(u.getPrestaServico());
		} catch (HomeHelpException e) {
		}		

		return login;
	}
	
	@POST
	@Path("criar")
	public LoginDTO criar(LoginDTO login) {
		try {
			Usuario u = usuarioService.criar(login.getId(), 
					login.getNome(), 
					login.getEmail(), 
					login.getLogin(), 
					login.getSenha(), 
					login.getEndereco(), 
					login.getPrestaServico());
			
			login.setSenha(null);
			login.setConfirmaSenha(null);
			login.setId(u.getId());
			login.setNome(u.getNome());
			login.setEndereco(u.getEndereco());
			login.setEmail(u.getEmail());
			login.setLogin(u.getLogin());
			login.setPrestaServico(u.getPrestaServico());			
		} catch (HomeHelpException e) {
			e.printStackTrace();
		}		
		
		return login;		
	}

}