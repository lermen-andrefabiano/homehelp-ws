package br.com.home.help;

import javax.inject.Named;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class EspecialidadeHibernate extends AbstractCrudHibernate<Especialidade, Long> implements EspecialidadeRepository {

}
