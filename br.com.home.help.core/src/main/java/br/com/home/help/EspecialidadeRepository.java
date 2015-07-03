package br.com.home.help;

import java.util.List;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.UsuarioEspecialidade;

interface EspecialidadeRepository {

    Especialidade obterPorId(Long id);

    Especialidade salvar(Especialidade obj);
    
    void persist(Especialidade obj);

    void excluir(Especialidade obj);
    
    boolean isNotEspecialidade(String descricao);
    
    List<UsuarioEspecialidade> listar(String str);

}
