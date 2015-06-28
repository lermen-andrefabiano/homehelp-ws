package br.com.home.help;

import javax.inject.Inject;

import org.junit.Test;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.test.spring.AbstractSpringTest;

public class TestEspecialidadeHibernate extends AbstractSpringTest {

    @Inject
    private EspecialidadeRepository especialidadeRep;

    @Test
    public void obterPorId() {
        assertNotNull(this.especialidadeRep.obterPorId(1L));
    }

    @Test
    public void salvar() {
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("CORTE DE GRAMA")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("TROCA DE CHUVEIRO")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("TROCA DE TORNEIRA")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("INSTALAÇÃO DE REDE WI-FI")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("LIMPEZA DE CANOS")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("TROCA DE TOMADA")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("TROCA DE LAMPADA")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("FORMATAÇÃO DE COMPUTADOR")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("LIMPEZA DE JANELAS")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("LAVAGEM DE CARROS")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("TROCA DE OLEO")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("CORTE DE GRAMA")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("PODA DE ARVORES")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("LAVAGEM DE CALÇADA")));
        
    }

    @Test
    public void excluir() {
        Especialidade m = this.especialidadeRep.obterPorId(3L);

        if (isResult(m, "excluir")) {
            this.especialidadeRep.excluir(m);
        }

    }
}
