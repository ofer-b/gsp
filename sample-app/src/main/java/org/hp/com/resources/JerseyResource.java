package org.hp.com.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("jersey-hello")
public class JerseyResource {
    private static final Logger LOGGER = Logger.getLogger(JerseyResource.class.getName());





    public JerseyResource() {
        LOGGER.fine("HelloWorldResource()");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "hello";
    }

}
