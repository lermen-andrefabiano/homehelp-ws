package br.com.home.help.test;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTest extends Assert {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

}
