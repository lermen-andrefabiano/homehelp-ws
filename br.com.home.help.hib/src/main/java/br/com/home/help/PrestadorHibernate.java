package br.com.home.help;

import javax.inject.Named;

import br.com.home.help.core.entidades.Prestador;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class PrestadorHibernate extends AbstractCrudHibernate<Prestador, Long> implements PrestadorRepository {

}
