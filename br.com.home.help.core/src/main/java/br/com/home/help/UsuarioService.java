package br.com.home.help;

import br.com.home.help.core.entidades.Usuario;
import br.com.home.help.util.HomeHelpException;



/**
 * 
 * Home Help.
 *
 * @author: andre.lermen 
 * @since: 23/06/2015
 *
 * Change History
 *
 * @author: andre.lermen
 * @date: 23/06/2015
 * @reason: Initial code.
 *
 */
public interface UsuarioService {
	
	String HOME_HELP_LOGIN_INVALIDO = "br.com.home.help.login.invalido";
	
	String HOME_HELP_SENHA_INVALIDA = "br.com.home.help.senha.invalida";

	Usuario login(String login, String senha) throws HomeHelpException;

	Usuario criar(Long usuarioId, String nome, String email, String login, String senha, String endereco, Boolean prestaServico) throws HomeHelpException;
    
    void addEspecialidade(Long valorCobrado, Long especialidadeId, Long usuarioId);

	Usuario obterPorId(Long id);
	
	void trocarSenha(Long usuarioId, String senha);
	
	Usuario salvar(Usuario obj);    

}
