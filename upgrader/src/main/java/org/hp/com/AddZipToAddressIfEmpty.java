package org.hp.com;

import liquibase.change.custom.CustomTaskChange;
import liquibase.database.Database;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.CustomChangeException;
import liquibase.exception.DatabaseException;
import liquibase.exception.SetupException;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by borshtei on 20/04/2015.
 * a custom liquibase upgrader example
 */
public class AddZipToAddressIfEmpty implements CustomTaskChange {
    private String newZipCode;


    public void setNewZipCode(String newZipCode) {
        this.newZipCode = newZipCode;
    }


    public void execute(Database database) throws CustomChangeException {
        final JdbcConnection conn = (JdbcConnection) database.getConnection();
        try {
            conn.setAutoCommit(false);
            final String insertTableSQL = "UPDATE address SET ad_zip = ? WHERE ad_zip is null";
            final PreparedStatement stmt = conn.prepareStatement(insertTableSQL);
            stmt.setString(1, newZipCode);
            stmt.executeUpdate();
            conn.commit();
        } catch (DatabaseException | SQLException e) {
            Logger.getLogger("failed to run custom upgrader");
        }
    }

    public String getConfirmationMessage() {
        return "this is a custom change";
    }

    public void setUp() throws SetupException {

    }

    public void setFileOpener(ResourceAccessor resourceAccessor) {

    }

    public ValidationErrors validate(Database database) {
        return null;
    }
}
