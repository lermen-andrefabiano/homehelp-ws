package br.com.home.help.test.spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.home.help.test.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-tests.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public abstract class AbstractSpringTest extends AbstractTest {

    protected boolean isResult(Object obj, String method) {
        if (obj == null) {
            notResult(method);
            return false;
        } else {
            return true;
        }
    }

    protected void notResult(String method) {
        notResult(method, null);
    }

    protected void notResult(String method, String str) {
        if (method == null) {
            method = "";
        }
        if (str == null) {
            str = "";
        }

        log.warn("Não foi encontrado resultados para testes em " + this.getClass().getSimpleName() + "#" + method + ". " + str);
    }

}
