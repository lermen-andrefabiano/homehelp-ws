package br.com.home.help;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.core.entidades.ChamadoHistorico;
import br.com.home.help.core.entidades.Cliente;
import br.com.home.help.core.entidades.Prestador;
import br.com.home.help.core.enuns.TipoPrioridade;
import br.com.home.help.core.enuns.TipoStatus;
import br.com.home.help.test.spring.AbstractSpringTest;

public class TestChamadoHibernate extends AbstractSpringTest {

    @Inject
    private ChamadoRepository chamadoRep;

    @Test
    public void obterPorId() {
        assertNotNull(this.chamadoRep.obterPorId(1L));
    }

    @Test
    public void salvar() {
        Chamado c = new Chamado(new Date(), "urgente", "chuveiro estragou", TipoStatus.A, TipoPrioridade.N, 
                new Cliente(4L), new Prestador(10L));

        List<ChamadoHistorico> historicos = new ArrayList<ChamadoHistorico>();
        historicos.add(new ChamadoHistorico(c.getData(), c.getStatus(), c));
        
        c.setHistoricos(historicos);

        this.chamadoRep.persist(c);

    }

    @Test
    public void excluir() {
        Chamado m = this.chamadoRep.obterPorId(3L);

        if (isResult(m, "excluir")) {
            this.chamadoRep.excluir(m);
        }

    }
}
