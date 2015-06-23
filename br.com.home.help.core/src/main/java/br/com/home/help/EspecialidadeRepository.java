package br.com.home.help;

import br.com.home.help.core.entidades.Especialidade;

interface EspecialidadeRepository {

    Especialidade obterPorId(Long especialidadeId);

    Especialidade salvar(Especialidade especialidade);

    void excluir(Especialidade especialidade);

}
