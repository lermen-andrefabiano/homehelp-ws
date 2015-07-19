package br.com.home.help;

import java.util.List;

import br.com.home.help.core.entidades.UsuarioEspecialidade;

interface UsuarioEspecialidadeRepository {

    UsuarioEspecialidade obterPorId(Long id);

    void persist(UsuarioEspecialidade obj);

    UsuarioEspecialidade salvar(UsuarioEspecialidade obj);

    void excluir(UsuarioEspecialidade obj);
    
    List<UsuarioEspecialidade> listar(String str);

	List<UsuarioEspecialidade> listarPorPrestador(Long prestadorId);

}
