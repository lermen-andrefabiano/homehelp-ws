package br.com.home.help.test.mokito;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

import br.com.home.help.test.AbstractTest;

public abstract class AbstractMokitoTest extends AbstractTest {

    @Before
    public void setUpToAll() {
        MockitoAnnotations.initMocks(this);
    }

}
