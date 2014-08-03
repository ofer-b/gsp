package org.hp.com;// org.hp.com.SpringApplicationContext.java

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Wrapper to always return a reference to the Spring Application Context from
 * within non-Spring enabled beans. Unlike Spring MVC's WebApplicationContextUtils
 * we do not need a reference to the Servlet context for this. All we need is
 * for this bean to be initialized during application startup.
 */
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    /**
     * This method is called from within the ApplicationContext once it is
     * done starting up, it will stick a reference to itself into this bean.
     * @param context a reference to the ApplicationContext.
     */
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        CONTEXT = context;
    }

    /**
     * Retrieves bean by specified class
     * If there are more that one of no bean implementing this interface registered in context
     * org.springframework.beans.BeansException will be raised.
     * @param tClass - interface class
     * @param <T> - class type that will be returned
     * @return found bean instance
     */
    public static <T> T getBean(Class<T> tClass) {
        return CONTEXT.getBean(tClass);
    }
}