package br.com.home.help;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Cliente;
import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.Prestador;
import br.com.home.help.core.entidades.PrestadorEspecialidade;
import br.com.home.help.core.entidades.Usuario;
import br.com.home.help.util.HomeHelpException;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class UsuarioServiceImpl implements UsuarioService, PrestadorService {

	@Inject
	private UsuarioRepository usuarioRep;

	@Inject
	private ClienteRepository clienteRep;

	@Inject
	private PrestadorRepository prestadorRep;

	@Inject
	private PrestadorEspecialidadeRepository prestadorEspecialidadeRep;

	@Override
	public void login(String login, String senha) throws HomeHelpException {

		Usuario u = usuarioRep.obterPorLogin(login);

		if (u == null) {
			throw new HomeHelpException(HOME_HELP_LOGIN_INVALIDO);
		}

		this.validaSenha(u, senha);

		if (u.getPrestaServico()) {
			Prestador p = prestadorRep.obterPorId(u.getId());
		} else {
			Cliente c = clienteRep.obterPorId(u.getId());
		}
	}

	private void validaSenha(Usuario u, String senha) throws HomeHelpException {
		if (!u.getSenha().equals(senha)) {
			throw new HomeHelpException(HOME_HELP_LOGIN_INVALIDO);
		}
	}

	@Override
	public void criar(String nome, String alias, String login, String senha,
			Boolean prestaServico) {
		if (prestaServico) {
			this.prestadorRep.persist(new Prestador(nome, alias, login, senha,
					prestaServico));
		} else {
			this.clienteRep.persist(new Cliente(nome, alias, login, senha,
					prestaServico));
		}
	}

	@Override
	public void addEspecialidade(Long valorCobrado, Long especialidadeId,
			Long prestadorId) {
		this.prestadorEspecialidadeRep.persist(new PrestadorEspecialidade(
				valorCobrado, new Especialidade(especialidadeId),
				new Prestador(prestadorId)));
	}

}