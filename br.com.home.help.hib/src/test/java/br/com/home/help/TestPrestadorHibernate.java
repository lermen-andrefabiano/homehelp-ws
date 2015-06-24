package br.com.home.help;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.Prestador;
import br.com.home.help.core.entidades.PrestadorEspecialidade;
import br.com.home.help.core.enuns.TipoUsuario;
import br.com.home.help.test.spring.AbstractSpringTest;

public class TestPrestadorHibernate extends AbstractSpringTest {

    @Inject
    private PrestadorRepository prestadorRep;

    @Test
    public void obterPorId() {
        assertNotNull(this.prestadorRep.obterPorId(1L));
    }

    @Test
    public void salvar() {        
        Prestador p = new Prestador();
        p.setNome("andre fabiano lermen");
        p.setAlias("lermen.andre");
        p.setLogin("lermen");
        p.setSenha("123456");
        p.setTipo(TipoUsuario.P);      
        
        List<PrestadorEspecialidade> especialidades = new ArrayList<PrestadorEspecialidade>();      
        
        especialidades.add(new PrestadorEspecialidade(15L, new Especialidade(1L), p));
        especialidades.add(new PrestadorEspecialidade(10L, new Especialidade(2L), p));        
        
        p.setEspecialidades(especialidades);       
      
        this.prestadorRep.persist(p);        
             
    }

    @Test
    public void excluir() {
        Prestador m = this.prestadorRep.obterPorId(3L);

        if (isResult(m, "excluir")) {
            this.prestadorRep.excluir(m);
        }

    }
}
