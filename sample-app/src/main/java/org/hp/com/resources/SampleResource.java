package org.hp.com.resources;

import com.hp.gsp.AbstractResource;
import org.hp.com.entities.SampleEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * Created by ofer on 29/07/14
 *
 */
@Path("resource")
public class SampleResource extends AbstractResource<SampleEntity> {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(@Context HttpHeaders headers, @QueryParam("name") String name) {
        if(name == null) {
            throw new IllegalArgumentException("name is illegal");
        }
        return "Hello " + name;
    }
}
