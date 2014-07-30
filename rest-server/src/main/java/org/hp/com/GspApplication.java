package org.hp.com;

import org.glassfish.jersey.server.ResourceConfig;
import org.hp.com.exception.CustomExceptionMapper;
import org.hp.com.resources.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by borshtei on 30-Jul-14.
 *
 */
public class GspApplication extends ResourceConfig {

    @Autowired
    Registrar registrar;


    /**
     * Register JAX-RS application components.
     */
    public GspApplication() {

        for (AbstractResource resource : registrar.getResources()) {
            register(resource);
        }

//         register(RequestContextFilter.class);
//        register(JerseyResource.class);
//        register(SpringSingletonResource.class);
//        register(SpringRequestResource.class);
        register(CustomExceptionMapper.class);
//        packages("org.hp.com.resources");
    }
}
