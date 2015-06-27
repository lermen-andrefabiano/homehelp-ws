package br.com.home.help;

import javax.inject.Inject;

import org.junit.Test;

import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.core.entidades.Classificacao;
import br.com.home.help.core.entidades.Cliente;
import br.com.home.help.core.entidades.Prestador;
import br.com.home.help.core.enuns.TipoNota;
import br.com.home.help.test.spring.AbstractSpringTest;

public class TestClassificacaoHibernate extends AbstractSpringTest {

    @Inject
    private ClassificaocaoRepository classificaocaoRep;

    @Test
    public void obterPorId() {
        assertNotNull(this.classificaocaoRep.obterPorId(1L));
    }

    @Test
    public void salvar() {
        Classificacao c = new Classificacao(TipoNota.NOVE, "recomendo excelente serviço", new Cliente(3L), 
                new Prestador(1L), new Chamado(3L));
        this.classificaocaoRep.persist(c);

    }

    @Test
    public void excluir() {
        Classificacao m = this.classificaocaoRep.obterPorId(3L);

        if (isResult(m, "excluir")) {
            this.classificaocaoRep.excluir(m);
        }

    }
}
