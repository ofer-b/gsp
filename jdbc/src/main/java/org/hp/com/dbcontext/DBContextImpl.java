package org.hp.com.dbcontext;

/**
 * Created by borshtei on 13-Aug-14.
 *
 */
public class DBContextImpl implements DBContext {

    private final String schemaName;

    public DBContextImpl(String schemaName) {
        this.schemaName = schemaName;
    }

    public DbType getDbType() {
        return null;
    }


    public String getDbSchemaName() {
        return schemaName;
    }
}
