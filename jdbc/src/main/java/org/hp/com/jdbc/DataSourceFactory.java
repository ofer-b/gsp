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

    public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String DATA_SOURCE_CLASS_NAME = "oracle.jdbc.pool.OracleDataSource";
    public static final String DEFAULT_SCHEMA_PASSWORD = "sampleapp";
    public static final String INIT_SQL = "SELECT 1 FROM DUAL";


    @Cacheable(value = "dataSource")
    public DataSource getOrCreateDataSource(final String schemaName) {
        System.out.println("creating new datasource");
        Properties props = new Properties();
        props.setProperty("dataSourceClassName", DATA_SOURCE_CLASS_NAME);
        props.setProperty("dataSource.user", schemaName);
        props.setProperty("dataSource.password", DEFAULT_SCHEMA_PASSWORD);
        props.setProperty("dataSource.url", JDBC_URL);
        HikariConfig config = new HikariConfig(props);
        config.setConnectionInitSql(INIT_SQL);

        return new HikariDataSource(config);
    }
}
