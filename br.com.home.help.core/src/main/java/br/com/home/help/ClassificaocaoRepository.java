package br.com.home.help;

import br.com.home.help.core.entidades.Classificacao;

interface ClassificaocaoRepository {

    Classificacao obterPorId(Long id);

    void persist(Classificacao obj);

    Classificacao salvar(Classificacao obj);

    void excluir(Classificacao obj);

}
