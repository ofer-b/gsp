package upgrade;

import liquibase.integration.spring.SpringLiquibase;
import org.hp.com.GspApi;
import org.hp.com.jdbc.DataSourceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by borshtei on 12-Aug-14.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:gsp-*-context.xml"})
public class CreateEmptySchemaTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    SpringLiquibase springLiquibase;

    @Test
    public void testCreateSchema() throws Exception {
//        liquibase.integration.commandline.Main.run(new String[]{
//                "--defaultsFile=db/properties/db.test.properties",
//                "--logLevel=debug",
//                "update"
//        });
//        runner.run();
        DataSourceFactory dataSourceFactory = GspApi.getBean(DataSourceFactory.class);
        springLiquibase.setDataSource(dataSourceFactory.getOrCreateDataSource("sampleapp"));

        springLiquibase.setShouldRun(true);

        //springLiquibase.setDataSource(new );
        springLiquibase.afterPropertiesSet();
    }
}
