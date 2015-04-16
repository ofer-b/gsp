package org.hp.com.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by borshtei on 18-Aug-14.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:gsp-*-context.xml"})
public class CreateDataSourceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    DataSourceFactory factory;

    @Test
    public void testGetDataSourceFromCache() throws Exception {
        ConnectionProperties conProp = new ConnectionProperties("connectionString", "userA", "passA");
        DataSource dataSource1 = factory.getOrCreateDataSource(conProp);
        DataSource dataSource2 = factory.getOrCreateDataSource(conProp);
        Assert.assertEquals(dataSource1, dataSource2);
    }

    @Test
    public void testGetDataSourceFromCache_DifferentConnectionProp() throws Exception {
        ConnectionProperties conProp1 = new ConnectionProperties("connectionString", "userA", "passA");
        ConnectionProperties conProp2 = new ConnectionProperties("connectionString", "userA", "passA");
        DataSource dataSource1 = factory.getOrCreateDataSource(conProp1);
        DataSource dataSource2 = factory.getOrCreateDataSource(conProp2);
        Assert.assertEquals(dataSource1, dataSource2);
    }


    @Test
    public void testCreateDataSource() throws Exception {
        ConnectionProperties conProp1 = new ConnectionProperties("connectionString", "userA", "passA");
        ConnectionProperties conProp2 = new ConnectionProperties("connectionString", "userB", "passB");
        DataSource dataSource1 = factory.getOrCreateDataSource(conProp1);
        DataSource dataSource2 = factory.getOrCreateDataSource(conProp2);
        Assert.assertNotEquals(dataSource1, dataSource2);
    }

}
