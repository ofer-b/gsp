package org.hp.com.resources;

import org.hp.com.GspApi;
import org.hp.com.ReadService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by ofer on 29/07/14.
 *
 */
public class AbstractResourceImpl<T> implements AbstractResource<T> {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        ReadService<T> readService = GspApi.getBean(ReadService.class);
        T o = readService.read(id);
        return Response.ok().entity(o).build();
    }
}
