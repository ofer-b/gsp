package org.hp.com.dbcontext;

/**
 * Created by borshtei on 13-Aug-14.
 *
 */
public interface DBContext {

    public enum DbType {
        Oracle, MSSQL
    }

    /**
     * get the type of the underlying database
     *
     * @return DB type code
     */
    DbType getDbType();

    /**
     * get the real name of the database schema
     *
     * @return schema's name
     */
    String getDbSchemaName();
}
