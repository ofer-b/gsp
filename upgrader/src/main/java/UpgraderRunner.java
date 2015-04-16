import liquibase.exception.LiquibaseException;
import org.hp.com.jdbc.ConnectionProperties;

/**
 * Created by borshtei on 16/04/2015.
 * main entry to create a new schema
 */
public class UpgraderRunner {

    public static void main(String[] args) throws LiquibaseException {

        //todo: the following should be taken from a config file
        final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        final String user = "sample_app";
        final String password = "sample_app";


        final ConnectionProperties connectionProperties = new ConnectionProperties(JDBC_URL, user, password);
        TenantUpgrader upgrader = new TenantUpgrader();
        upgrader.upgradeSchema(connectionProperties);
    }
}
