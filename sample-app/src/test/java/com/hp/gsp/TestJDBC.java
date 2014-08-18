package com.hp.gsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by borshtei on 05-Aug-14.
 *
 */
@ContextConfiguration("classpath:gsp-*-context.xml")
public class TestJDBC extends AbstractJUnit4SpringContextTests {





    @org.junit.Test
    public void testConnect() throws Exception {


    }
}
