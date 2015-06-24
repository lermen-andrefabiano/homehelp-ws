package br.com.home.help;

import javax.inject.Named;

import br.com.home.help.core.entidades.Classificacao;
import br.com.home.help.crud.AbstractCrudHibernate;

@Named
class ClassificacaoHibernate extends AbstractCrudHibernate<Classificacao, Long> implements ClassificaocaoRepository {

}
