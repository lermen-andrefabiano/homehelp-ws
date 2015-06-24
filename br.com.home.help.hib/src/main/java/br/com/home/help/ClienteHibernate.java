package br.com.home.help;

import javax.inject.Named;

import br.com.home.help.core.entidades.Cliente;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class ClienteHibernate extends AbstractCrudHibernate<Cliente, Long> implements ClienteRepository {

}
