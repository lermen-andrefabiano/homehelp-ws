package br.com.home.help;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.UsuarioEspecialidade;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class EspecialidadeHibernate extends AbstractCrudHibernate<Especialidade, Long>
		implements EspecialidadeRepository {

	@Override
	public boolean isNotEspecialidade(String descricao) {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createCriteria(Especialidade.class);
			c.add(Restrictions.eq("descricao", descricao));
			return c.uniqueResult() == null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<UsuarioEspecialidade> listar(String str) {
		try {
			@SuppressWarnings("unchecked")
			List<UsuarioEspecialidade> lst = getHibernateTemplate().getSessionFactory().getCurrentSession()
					.createCriteria(UsuarioEspecialidade.class)
					.createAlias("especialidade", "e")
					.createAlias("usuario", "u")
					.setMaxResults(MAX_RESULTS_LST)
					.add(Restrictions.ilike("e.descricao", "%" + str + "%")).list();
			return lst;
		} catch (Exception e) {
			throw e;
		}

	}

}
