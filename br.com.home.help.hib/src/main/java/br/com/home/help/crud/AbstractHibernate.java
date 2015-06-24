package br.com.home.help.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe com utilidades para hibernate usando como base o HibernateDaoSupport
 * do spring
 * 
 * @author andre.lermen
 * 
 */
@Transactional
public abstract class AbstractHibernate extends HibernateDaoSupport {

	/**
	 * seta a factory do hibernate no HibernateDaoSupport
	 * 
	 * @author andre.lermen
	 * 
	 * @param factory
	 */
	@Inject
	public void setSessionFactory2(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	/**
	 * executa a query retornando a lista tipificada
	 * 
	 * @author andre.lermen
	 * 
	 * @param q
	 *            query
	 * @param type
	 *            tipo de retorno da lista
	 * @return lista
	 */
	protected <T> List<T> getResultList(Query q, Class<T> type) {
		@SuppressWarnings("unchecked")
		List<T> list = q.list();
		return list;
	}

	/**
	 * executa a query retornando a lista tipificada
	 * 
	 * @author andre.lermen
	 * 
	 * @param q
	 *            query
	 * @param type
	 *            tipo de retorno da lista
	 * @param transform
	 *            se true, aplica o utilitario Transformers.aliasToBean do
	 *            hibernate
	 * @return lista
	 */
	protected <T> List<T> getResultList(SQLQuery q, Class<T> type,
			boolean transform) {
		if (transform) {
			q.setResultTransformer(Transformers.aliasToBean(type));
		}
		@SuppressWarnings("unchecked")
		List<T> list = q.list();
		return list;
	}

	/**
	 * cria uma Query baseada em um arquivo que deve existir no mesmo pacote da
	 * classe
	 * 
	 * @author andre.lermen
	 * 
	 * @param file
	 *            nome do arquivo
	 * @return query
	 */
	protected Query loadQuery(String file) {
		String sq = loadFile(file);
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery(sq);
	}

	/**
	 * cria uma SQLQuery baseada em um arquivo que deve existir no mesmo pacote
	 * da classe
	 * 
	 * @author andre.lermen
	 * 
	 * @param file
	 *            nome do arquivo
	 * @return query
	 */
	protected SQLQuery loadSQLQuery(String file) {
		String sq = loadFile(file);
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createSQLQuery(sq);
	}

	/**
	 * carrega o conteudo de um arquivo que deve existir no mesmo pacote da
	 * classe
	 * 
	 * @author andre.lermen
	 * 
	 * @param file
	 *            nome do arquivo
	 * @return conteudo do arquivo em String
	 */
	protected String loadFile(String arquivo) throws IllegalArgumentException {

		String dirpack = this.getClass().getPackage().getName()
				.replace('.', '/');
		arquivo = dirpack + "/" + arquivo;

		try {

			InputStream in = this.getClass().getClassLoader()
					.getResourceAsStream(arquivo);

			if (in == null) {
				throw new IllegalArgumentException("Arquivo '" + arquivo
						+ "' NAO encontrado no classpath");
			}

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			StringBuilder sb = new StringBuilder();
			String s = null;
			while ((s = reader.readLine()) != null) {
				sb.append(s + " ");
			}

			return sb.toString();
		} catch (IOException e) {
			throw new IllegalArgumentException("erro ao ler o arquivo '"
					+ arquivo + "'", e);
		}
	}

	/**
	 * aplica o fetch em uma lista para forçar o carregamento quando a lista é
	 * LAZY
	 * 
	 * @author andre.lermen
	 * 
	 * @param lista
	 *            lazy
	 */
	protected void fetch(Collection<?> lista) {
		if (lista != null) {
			lista.size();
		}
	}

	/**
	 * aplica o fetch em um objeto para forçar o carregamento quando o objeto é
	 * LAZY
	 * 
	 * @author andre.lermen
	 * 
	 * @param objeto
	 *            lazy
	 */
	protected void fetch(Object objeto) {
		if (objeto == null) {
			return;
		}
		try {
			Method m = objeto.getClass().getDeclaredMethod("getId");
			m.invoke(objeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
