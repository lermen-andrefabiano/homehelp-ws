package br.com.home.help;

import java.util.List;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.UsuarioEspecialidade;

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
public interface EspecialidadeService {

    Especialidade obterPorId(Long especialidadeId);

    Especialidade salvar(String descricao);
    
    List<UsuarioEspecialidade> listar(String str);

}
