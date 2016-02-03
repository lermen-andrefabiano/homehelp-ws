package br.com.home.help;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.Usuario;
import br.com.home.help.core.entidades.UsuarioEspecialidade;
import br.com.home.help.util.HomeHelpException;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioRepository usuarioRep;

	@Inject
	private UsuarioEspecialidadeRepository usuarioEspecialidadeRep;
	
	@Override
	public Usuario obterPorId(Long id) {
		return usuarioRep.obterPorId(id);
	}	

	@Override
	public Usuario login(String login, String senha) throws HomeHelpException {

		Usuario u = usuarioRep.obterPorLogin(login);

		if (u == null) {
			throw new HomeHelpException(HOME_HELP_LOGIN_INVALIDO);
		}

		this.validaSenha(u, senha);
		
		return u;

	}

	private void validaSenha(Usuario u, String senha) throws HomeHelpException {
		if (!u.getSenha().equals(senha)) {
			throw new HomeHelpException(HOME_HELP_SENHA_INVALIDA);
		}
	}

	@Override
	public Usuario criar(Long usuaroId, String nome, String email, String login, String senha, String endereco, Boolean prestaServico) {
		Usuario u = null;
		
		if(usuaroId!=null){
			u = this.usuarioRep.obterPorId(usuaroId);
			u.setEmail(email);
			u.setNome(nome);			
			u.setSenha(senha);
			u.setPrestaServico(prestaServico);
		}else{
			u = new Usuario(nome, email, login, senha, endereco, prestaServico);
		}		
		
		u = this.usuarioRep.salvar(u);		
		return u;
	}

	@Override
	public void addEspecialidade(Long valorCobrado, Long especialidadeId,
			Long usuarioId) {
		this.usuarioEspecialidadeRep.persist(new UsuarioEspecialidade(
				valorCobrado, new Especialidade(especialidadeId), new Usuario(
						usuarioId)));
	}

	@Override
	public void trocarSenha(Long usuarioId, String senha) {
		Usuario u = this.obterPorId(usuarioId);
		u.setSenha(senha);
		
		this.usuarioRep.salvar(u);		
	}

	@Override
	public Usuario salvar(Usuario obj) {		
		return this.usuarioRep.salvar(obj);
	}

}