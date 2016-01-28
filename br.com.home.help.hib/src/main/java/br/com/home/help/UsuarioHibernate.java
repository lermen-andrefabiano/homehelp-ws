package br.com.home.help;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.home.help.core.entidades.Usuario;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class UsuarioHibernate extends AbstractCrudHibernate<Usuario, Long> implements UsuarioRepository {

	@Override
	public Usuario obterPorLogin(String login) {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Usuario.class);
			c.add(Restrictions.eq("login", login));
			return (Usuario) c.uniqueResult();
		} catch (Exception e) {
			throw e;
		}
		
	}

}
