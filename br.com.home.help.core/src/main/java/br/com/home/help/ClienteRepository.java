package br.com.home.help;

import br.com.home.help.core.entidades.Cliente;

interface ClienteRepository {

    Cliente obterPorId(Long id);

    void persist(Cliente obj);
    
    Cliente salvar(Cliente obj);

    void excluir(Cliente obj);

}
