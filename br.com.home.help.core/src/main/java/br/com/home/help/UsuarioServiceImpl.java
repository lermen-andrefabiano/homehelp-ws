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
	public void login(String login, String senha) throws HomeHelpException {

		Usuario u = usuarioRep.obterPorLogin(login);

		if (u == null) {
			throw new HomeHelpException(HOME_HELP_LOGIN_INVALIDO);
		}

		this.validaSenha(u, senha);

	}

	private void validaSenha(Usuario u, String senha) throws HomeHelpException {
		if (!u.getSenha().equals(senha)) {
			throw new HomeHelpException(HOME_HELP_LOGIN_INVALIDO);
		}
	}

	@Override
	public void criar(String nome, String alias, String login, String senha,
			Boolean prestaServico) {

		this.usuarioRep.persist(new Usuario(nome, alias, login, senha,
				prestaServico));

	}

	@Override
	public void addEspecialidade(Long valorCobrado, Long especialidadeId,
			Long usuarioId) {
		this.usuarioEspecialidadeRep.persist(new UsuarioEspecialidade(
				valorCobrado, new Especialidade(especialidadeId), new Usuario(
						usuarioId)));
	}

}