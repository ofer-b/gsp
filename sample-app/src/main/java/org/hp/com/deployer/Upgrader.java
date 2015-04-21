package org.hp.com.deployer;

import liquibase.exception.LiquibaseException;
import org.hp.com.Configuration;
import org.hp.com.TenantUpgrader;
import org.hp.com.jdbc.ConnectionProperties;

/**
 * Created by borshtei on 16/04/2015.
 * main entry to create a new schema
 */
public class Upgrader {

    public static void main(String[] args) throws LiquibaseException {

        final String JDBC_URL = Configuration.INSTANCE.getString("jdbc.connection.string");
        final String user = Configuration.INSTANCE.getString("jdbc.tenant.user");
        final String password = Configuration.INSTANCE.getString("jdbc.tenant.password");

        final ConnectionProperties connectionProperties = new ConnectionProperties(JDBC_URL, user, password);
        TenantUpgrader upgrader = new TenantUpgrader();
        upgrader.upgradeSchema(connectionProperties);
    }
}
