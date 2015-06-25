package br.com.home.help;

import br.com.home.help.core.entidades.PrestadorEspecialidade;

interface PrestadorEspecialidadeRepository {

    PrestadorEspecialidade obterPorId(Long id);

    void persist(PrestadorEspecialidade obj);

    PrestadorEspecialidade salvar(PrestadorEspecialidade obj);

    void excluir(PrestadorEspecialidade obj);

}
