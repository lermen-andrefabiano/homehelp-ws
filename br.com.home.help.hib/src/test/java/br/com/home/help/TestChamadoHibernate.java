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
                new Cliente(3L), new Prestador(1L));

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
    
    @Test
    public void listarPorPrestador() {
    	List<Chamado> lst = this.chamadoRep.listarPorPrestador(1L);
    	
    	for(Chamado c : lst){
    		log.debug(c.getDescricao());
    	}
    	
    }
    
    @Test
    public void listarPorCliente() {
    	List<Chamado> lst = this.chamadoRep.listarPorCliente(3L);
    	
    	for(Chamado c : lst){
    		log.debug(c.getDescricao());
    	}
    	
    }
    
}
