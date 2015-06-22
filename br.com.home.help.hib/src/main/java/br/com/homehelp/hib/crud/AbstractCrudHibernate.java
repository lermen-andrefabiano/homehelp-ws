package br.com.homehelp.hib.crud;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.MappingException;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * classe utilitaria para operações de CRUD de uma entidade específica
 * 
 * @author fabio.arezi
 * 
 * @param <E>
 *            entidade
 * @param <ID>
 *            chave primaria
 */
@Transactional
public abstract class AbstractCrudHibernate<E, ID extends Serializable> extends
		AbstractHibernate {

	private Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractCrudHibernate() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}

	/**
	 * 
	 * obtem o objeto do banco de acordo com a chave primária se objeto não for encontrado, retornará null
	 * 
	 * @author andre.lermen
	 * 
	 * @param id chave primária
	 * 
	 * @return objeto do banco
	 */
	public E obterPorId(ID id) {
		return (E) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * salva a entidade (fazendo o merge) se o id não for encontrado na tabela,
	 * será feito o insert, senão update
	 * 
	 * @author andre.lermen
	 * 
	 * @param entity
	 * 
	 * @return retorna o objeto entidade salvo, no contexto de persistencia
	 */
	public E salvar(E entity) {
		return (E) getHibernateTemplate().merge(entity);
	}

	/**
	 * Exclui a entidade (não é necessario estar no contexto de persistencia)
	 * bastando ter o valor do ID
	 * 
	 * @author andre.lermen
	 * 
	 * @param entity
	 */	
	public void excluir(E entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * lista as entidades referente a tabela
	 * 
	 * para a listagem, será procurado uma named query no padrão:
	 * <Entidade>.listar se for encontrada a named query, a mesma será
	 * executada, senão será executado o hql: from <Entidade> e
	 * 
	 * @author fabio.arezi
	 * 
	 * @return lista de entidades
	 */
	public List<E> listar() {

		Query q;
		try {
			q = getHibernateTemplate().getSessionFactory().getCurrentSession()
					.getNamedQuery(entityClass.getSimpleName() + ".listar");
		} catch (MappingException e) { // query nao encontrada
			q = getHibernateTemplate().getSessionFactory().getCurrentSession()
					.createQuery("from " + entityClass.getSimpleName() + " e");
		}

		@SuppressWarnings("unchecked")
		List<E> lst = q.list();

		return lst;
	}

	/**
	 * obtem a quantidade de registros na tabela
	 * 
	 * @author andre.lermen
	 * 
	 * @return nro de registros
	 */
	public long countRecords() {
		return (Long) getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("select count(o) from " + entityClass.getSimpleName() + " as o").uniqueResult();
	}

}