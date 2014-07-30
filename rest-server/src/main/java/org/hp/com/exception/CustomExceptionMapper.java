package org.hp.com.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by borshtei on 30-Jul-14.
 *
 */
public class CustomExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException exception) {
        return Response.ok("Illegal Argument Exception Caught").build();
    }
}
