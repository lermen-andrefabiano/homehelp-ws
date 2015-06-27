package br.com.home.help;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import br.com.home.help.core.entidades.Agenda;
import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.core.enuns.TipoAgenda;
import br.com.home.help.test.spring.AbstractSpringTest;

public class TestAgendaHibernate extends AbstractSpringTest {

	@Inject
	private AgendaRepository agendaRep;

	@Test
	public void obterPorId() {
		assertNotNull(this.agendaRep.obterPorId(1L));
	}

	@Test
	public void salvar() {
		Agenda a = new Agenda(new Date(), TipoAgenda.A, "ok", new Chamado(3L));

		this.agendaRep.persist(a);
	}

	@Test
	public void excluir() {
		Agenda m = this.agendaRep.obterPorId(3L);

		if (isResult(m, "excluir")) {
			this.agendaRep.excluir(m);
		}

	}
}
