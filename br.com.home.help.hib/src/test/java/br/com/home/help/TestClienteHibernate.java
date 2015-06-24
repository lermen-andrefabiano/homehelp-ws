package br.com.home.help;

import javax.inject.Inject;

import org.junit.Test;

import br.com.home.help.core.entidades.Cliente;
import br.com.home.help.core.enuns.TipoUsuario;
import br.com.home.help.test.spring.AbstractSpringTest;

public class TestClienteHibernate extends AbstractSpringTest {

    @Inject
    private ClienteRepository clienteRep;

    @Test
    public void obterPorId() {
        assertNotNull(this.clienteRep.obterPorId(1L));
    }

    @Test
    public void salvar() {        
        Cliente c = new Cliente();
        c.setNome("andre fabiano lermen");
        c.setAlias("lermen.andre");
        c.setLogin("lermen");
        c.setSenha("123456");
        c.setTipo(TipoUsuario.U);       
        
        this.clienteRep.persist(c);        
             
    }

    @Test
    public void excluir() {
        Cliente m = this.clienteRep.obterPorId(3L);

        if (isResult(m, "excluir")) {
            this.clienteRep.excluir(m);
        }

    }
}
