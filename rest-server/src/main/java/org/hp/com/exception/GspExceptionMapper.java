package org.hp.com.exception;

/**
 * Created by borshtei on 30-Jul-14.
 *
 */
public interface GspExceptionMapper extends javax.ws.rs.ext.ExceptionMapper<Exception> {

    public String getExceptionId();

    public int getStatusCode();
}
