package br.com.home.help;

import javax.inject.Named;

import br.com.home.help.core.entidades.UsuarioEspecialidade;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class UsuarioEspecialidadeHibernate extends
		AbstractCrudHibernate<UsuarioEspecialidade, Long> implements
		UsuarioEspecialidadeRepository {

}
