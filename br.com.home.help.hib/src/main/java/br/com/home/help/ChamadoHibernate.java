package br.com.home.help;

import javax.inject.Named;

import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class ChamadoHibernate extends AbstractCrudHibernate<Chamado, Long> implements ChamadoRepository {

}
