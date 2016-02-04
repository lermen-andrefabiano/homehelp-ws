package br.com.home.help;

import br.com.home.help.core.entidades.Usuario;

interface UsuarioRepository {

	Usuario obterPorLogin(String login);

	Usuario obterPorId(Long id);

	void persist(Usuario obj);

	Usuario salvar(Usuario obj);

	void excluir(Usuario obj);

	Usuario obterPorEmail(String email);

}
