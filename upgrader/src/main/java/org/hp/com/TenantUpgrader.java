package org.hp.com;

import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.hp.com.jdbc.ConnectionProperties;
import org.hp.com.jdbc.DataSourceFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * Created by borshtei on 16/04/2015.
 * This class create a new DB schema based on liquibase configuration files
 */
public class TenantUpgrader {

    //todo: load context in a generic way
    private static final String[] SPRING_CONFIG_FILES = new String[]{"classpath*:gsp-*-context.xml"};

    public void upgradeSchema(ConnectionProperties connectionProperties) throws LiquibaseException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILES);
        SpringLiquibase springLiquibase =ctx.getBean(SpringLiquibase.class);

//        liquibase.integration.commandline.Main.run(new String[]{
//                "--defaultsFile=db/properties/db.test.properties",
//                "--logLevel=debug",
//                "update"
//        });
//        runner.run();
        DataSourceFactory dataSourceFactory = GspApi.getBean(DataSourceFactory.class);
        final DataSource dataSource = dataSourceFactory.getOrCreateDataSource(connectionProperties);
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setShouldRun(true);
        //springLiquibase.setDataSource(new );
        springLiquibase.afterPropertiesSet();
    }
}
