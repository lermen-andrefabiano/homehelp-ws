package br.com.home.help;

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

    void login(String login, String senha) throws HomeHelpException;

    void criar(String nome, String alias, String login, String senha, Boolean prestaServico) throws HomeHelpException;
    

}
