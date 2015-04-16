package org.hp.com.jdbc;

import org.hp.com.dbcontext.DBContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by borshtei on 28-Jul-14.
 *
 */
@Component
public class JDBCTemplateFactory {

    @Autowired
    private DataSourceFactory dataSourceFactory;

    public JDBCTemplate getJdbcTemplate(ConnectionProperties connectionProperties) {
        DataSource dataSource = dataSourceFactory.getOrCreateDataSource(connectionProperties);
        return new JDBCTemplateImpl(dataSource);
    }





}
