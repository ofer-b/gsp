package org.hp.com.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * Created by borshtei on 20/04/2015.
 *
 */
@Path("test")
public class CustomResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(@Context HttpHeaders headers, @QueryParam("name") String name) {
        if(name == null) {
            throw new IllegalArgumentException("name is illegal");
        }
        return "Hello " + name;
    }

}
