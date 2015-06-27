package br.com.home.help;

import javax.inject.Named;

import br.com.home.help.core.entidades.PrestadorEspecialidade;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class PrestadorEspecialidadeHibernate extends
		AbstractCrudHibernate<PrestadorEspecialidade, Long> implements
		PrestadorEspecialidadeRepository {

}
