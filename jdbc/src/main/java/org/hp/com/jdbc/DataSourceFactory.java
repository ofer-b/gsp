package org.hp.com.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by borshtei on 17-Aug-14.
 *
 */
@Component
public class DataSourceFactory {


    /**
     * Get or create a new DataSource (which is a DB connection to a specific DB schema).
     * the connection is cached via spring. if a free connection already exists with the given connectionProperties,
     * the cached value will be returned
     */
    @Cacheable(value = "dataSource")
    public DataSource getOrCreateDataSource(final ConnectionProperties connectionProperties) {
        System.out.println("creating new datasource");
        Properties props = new Properties();
        props.setProperty("dataSourceClassName", connectionProperties.getDataSourceClassName());
        props.setProperty("dataSource.user", connectionProperties.getUserName());
        props.setProperty("dataSource.password", connectionProperties.getPassword());
        props.setProperty("dataSource.url", connectionProperties.getJdbcURL());
        HikariConfig config = new HikariConfig(props);
        config.setConnectionInitSql(connectionProperties.getInitSql());

        return new HikariDataSource(config);
    }
}
