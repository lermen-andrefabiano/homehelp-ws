package br.com.home.help;

import br.com.home.help.core.entidades.Usuario;

interface UsuarioRepository {

	Usuario obterPorLogin(String login);

}
