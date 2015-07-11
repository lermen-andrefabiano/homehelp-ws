package br.com.home.help;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.home.help.core.entidades.Agenda;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class AgendaHibernate extends AbstractCrudHibernate<Agenda, Long> implements
		AgendaRepository {

	@Override
	public Agenda obterPorChamdo(Long chamadoId) {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createCriteria(Agenda.class);
			c.add(Restrictions.eq("chamado.id", chamadoId));
			Agenda a = (Agenda) c.uniqueResult();
			return a;
		} catch (Exception e) {
			throw e;
		}
	}

}
