package br.com.home.help;

import javax.inject.Named;

import br.com.home.help.core.entidades.Agenda;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class AgendaHibernate extends AbstractCrudHibernate<Agenda, Long> implements AgendaRepository {

}
