package br.com.home.help;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.core.enuns.TipoStatus;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class ChamadoHibernate extends AbstractCrudHibernate<Chamado, Long> implements
		ChamadoRepository {

	@Override
	public List<Chamado> listarPorUsuario(Long usuarioId) {
		Criteria c = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Chamado.class);		
		c.createAlias("especialidade", "especialidade");
		c.createAlias("prestador", "prestador");
		c.add(Restrictions.eq("usuario.id", usuarioId));
		c.add(Restrictions.eq("status", TipoStatus.E));
		c.addOrder(Order.asc("status"));
		c.setMaxResults(MAX_RESULTS_LST);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Chamado> lst = c.list();
		return lst;
	}

	@Override
	public List<Chamado> listarChamadosAbertos(Long usuarioid) {
		Criteria c = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Chamado.class);		
		c.createAlias("especialidade", "especialidade");
		c.createAlias("usuario", "usuario");
		c.add(Restrictions.eq("prestador.id", usuarioid));
		c.add(Restrictions.eq("status", TipoStatus.A));
		c.addOrder(Order.asc("status"));
		c.setMaxResults(MAX_RESULTS_LST);
		@SuppressWarnings("unchecked")
		List<Chamado> lst = c.list();
		return lst;
	}

}
