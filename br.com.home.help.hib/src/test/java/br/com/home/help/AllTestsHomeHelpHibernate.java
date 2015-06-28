package br.com.home.help;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestEspecialidadeHibernate.class,
    TestUsuarioHibernate.class,   
    TestChamadoHibernate.class,
    TestClassificacaoHibernate.class,
    TestAgendaHibernate.class,
    TestChamadoService.class
})
public class AllTestsHomeHelpHibernate {
}
