package br.com.home.help;

import br.com.home.help.core.entidades.Agenda;

interface AgendaRepository {

    Agenda obterPorId(Long id);

    void persist(Agenda obj);

    Agenda salvar(Agenda obj);

    void excluir(Agenda obj);
    
    Agenda obterPorChamdo(Long chamadoId);    

}