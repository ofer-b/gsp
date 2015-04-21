package org.hp.com;

import org.hp.com.jdbc.ConnectionProperties;
import org.hp.com.jdbc.JDBCTemplate;
import org.hp.com.jdbc.JDBCTemplateFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by borshtei on 13-Aug-14.
 * this class is responsible for creating and managing DB schemas
 *
 */
public class SchemaManager {

    //todo: load context in a generic way
    private static final String[] SPRING_CONFIG_FILES = new String[]{"gsp-data-source-context.xml"};

    public void createNewSchema(String schemaName) {
        final String JDBC_URL = Configuration.INSTANCE.getString("jdbc.connection.string");
        final String user = Configuration.INSTANCE.getString("jdbc.admin.user");
        final String password = Configuration.INSTANCE.getString("jdbc.admin.password");

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILES);
        JDBCTemplateFactory jdbcTemplateFactory = ctx.getBean(JDBCTemplateFactory.class);
        final ConnectionProperties connectionProperties = new ConnectionProperties(JDBC_URL, user, password);
        JDBCTemplate jdbcTemplate = jdbcTemplateFactory.getJdbcTemplate(connectionProperties);

        try {
            jdbcTemplate.execute("drop user " + schemaName + " cascade");
        } catch (Exception e) {
            //do nothing
        }
        jdbcTemplate.execute("create user " + schemaName + " identified by " + schemaName);
        jdbcTemplate.execute("grant connect, resource, create view to " + schemaName);
    }
}
