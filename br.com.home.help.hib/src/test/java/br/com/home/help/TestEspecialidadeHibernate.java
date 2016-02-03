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
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Corte de Grama")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Troca de Chuveiro")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Troca de Torneira")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Instalação de Rede Wi-fi")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Limpeza de Canos")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Troca de Tomada")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Troca de Lampada")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Formatacao de Computador")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Limpeza de Janelas")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Lavagem de Carro")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Troca de Oleo")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Corte de Cabelo")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Poda de Arvores")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Limpeza de Casa")));
        
    }

    @Test
    public void excluir() {
        Especialidade m = this.especialidadeRep.obterPorId(3L);

        if (isResult(m, "excluir")) {
            this.especialidadeRep.excluir(m);
        }

    }
}
