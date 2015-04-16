package org.hp.com.jdbc;

/**
 * Created by borshtei on 16/04/2015.
 *
 */
public class ConnectionProperties {

    //public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DATA_SOURCE_CLASS_NAME = "oracle.jdbc.pool.OracleDataSource";
    private static final String INIT_SQL = "SELECT 1 FROM DUAL";

    private String jdbcURL;
    private String userName;
    private String password;

    public ConnectionProperties(String jdbcURL, String userName, String password) {
        this.jdbcURL = jdbcURL;
        this.userName = userName;
        this.password = password;
    }

    public String getDataSourceClassName() {
        return DATA_SOURCE_CLASS_NAME;
    }

    public String getInitSql() {
        return INIT_SQL;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionProperties that = (ConnectionProperties) o;

        if (jdbcURL != null ? !jdbcURL.equals(that.jdbcURL) : that.jdbcURL != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        return !(password != null ? !password.equals(that.password) : that.password != null);

    }

    @Override
    public int hashCode() {
        int result = jdbcURL != null ? jdbcURL.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
