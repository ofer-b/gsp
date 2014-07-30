package org.hp.com;

import org.hp.com.resources.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Set;

/**
 * Created by borshtei on 30-Jul-14.
 *
 */
public class Registrar {
    private Set<AbstractResource> resources = Collections.emptySet();

//    private Set<ExceptionMapper> exceptionMappers = Collections.emptySet();
//    public Set<ExceptionMapper> getExceptionMappers() {
//        return exceptionMappers;
//    }
//
//    @Autowired
//    public void setExceptionMappers(Set<ExceptionMapper> exceptionMappers) {
//        this.exceptionMappers = exceptionMappers;
//    }

    @Autowired
    public void setResources(final Set<AbstractResource> resources) {
        this.resources = resources;
    }

    public Set<AbstractResource> getResources() {
        return resources;
    }
}
