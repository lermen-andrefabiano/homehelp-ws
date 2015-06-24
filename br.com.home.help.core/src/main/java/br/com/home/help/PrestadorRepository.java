package br.com.home.help;

import br.com.home.help.core.entidades.Prestador;

interface PrestadorRepository {

    Prestador obterPorId(Long id);

    void persist(Prestador obj);

    Prestador salvar(Prestador obj);

    void excluir(Prestador obj);

}
