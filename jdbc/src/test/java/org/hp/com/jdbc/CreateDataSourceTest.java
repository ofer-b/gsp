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
        DataSource dataSource1 = factory.getOrCreateDataSource("schema-a");
        DataSource dataSource2 = factory.getOrCreateDataSource("schema-a");
        Assert.assertEquals(dataSource1, dataSource2);
    }

    @Test
    public void testCreateDataSource() throws Exception {
        DataSource dataSource1 = factory.getOrCreateDataSource("schema-a");
        DataSource dataSource2 = factory.getOrCreateDataSource("schema-b");
        Assert.assertNotEquals(dataSource1, dataSource2);
    }

}
