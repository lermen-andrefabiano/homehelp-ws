package br.com.home.help;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class ChamadoHibernate extends AbstractCrudHibernate<Chamado, Long> implements
		ChamadoRepository {

	@Override
	public List<Chamado> listarPorUsuario(Long usuarioId) {
		Criteria c = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Chamado.class);
		c.add(Restrictions.eq("usuario.id", usuarioId));
		c.addOrder(Order.asc("status"));
		c.setMaxResults(MAX_RESULTS_LST);
		@SuppressWarnings("unchecked")
		List<Chamado> lst = c.list();
		return lst;
	}

	@Override
	public List<Chamado> listarPorPrestador(Long prestadorId) {
		Criteria c = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Chamado.class);
		c.add(Restrictions.eq("prestador.id", prestadorId));
		c.addOrder(Order.asc("status"));
		c.setMaxResults(MAX_RESULTS_LST);
		@SuppressWarnings("unchecked")
		List<Chamado> lst = c.list();
		return lst;
	}

}
