package br.com.home.help;



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

    void login(String login, String senha, Boolean prestaServico);

    void criar(String nome, String alias, String login, String senha, Boolean prestaServico);
    

}
