package br.com.home.help;

import br.com.home.help.core.entidades.UsuarioEspecialidade;

interface UsuarioEspecialidadeRepository {

    UsuarioEspecialidade obterPorId(Long id);

    void persist(UsuarioEspecialidade obj);

    UsuarioEspecialidade salvar(UsuarioEspecialidade obj);

    void excluir(UsuarioEspecialidade obj);

}
