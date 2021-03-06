package br.com.home.help;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.UsuarioEspecialidade;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class UsuarioEspecialidadeHibernate extends
		AbstractCrudHibernate<UsuarioEspecialidade, Long> implements
		UsuarioEspecialidadeRepository {

	@Override
	public List<UsuarioEspecialidade> getUsuarioEspecialidades(String str) {
		try {
			@SuppressWarnings("unchecked")
			List<UsuarioEspecialidade> lst = getHibernateTemplate()
					.getSessionFactory().getCurrentSession()
					.createCriteria(UsuarioEspecialidade.class)
					.createAlias("especialidade", "e")
					.createAlias("usuario", "u")
					.setMaxResults(MAX_RESULTS_LST)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.add(Restrictions.ilike("e.descricao", "%" + str + "%"))
					.list();
			return lst;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<UsuarioEspecialidade> getEspecialidaPrestador(Long prestadorId) {
		@SuppressWarnings("unchecked")
		List<UsuarioEspecialidade> lst = getHibernateTemplate()
				.getSessionFactory().getCurrentSession()
				.createCriteria(UsuarioEspecialidade.class)
				.createAlias("especialidade", "e")
				.add(Restrictions.eq("usuario.id", prestadorId))
				.setMaxResults(MAX_RESULTS_LST)							
				.list();
		return lst;
	}

	@Override
	public List<Especialidade> getEspecialidades(String especialidade) {
		try {
			@SuppressWarnings("unchecked")
			List<Especialidade> lst = getHibernateTemplate()
					.getSessionFactory().getCurrentSession()
					.createCriteria(Especialidade.class)				
					.add(Restrictions.ilike("descricao", "%" + especialidade + "%"))
					.setMaxResults(MAX_RESULTS_LST)		
					.list();
			return lst;
		} catch (Exception e) {
			throw e;
		}
	}

}
