package org.hp.com;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class launches the web application in an embedded Jetty container.
 * This is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 *
 * @author John Simone
 */
public class WebAppRunner {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //todo: take this from config
        String webappDirLocation = "web-app/defaultroot";

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        Server server = new Server(Integer.valueOf(webPort));
        WebAppContext webApp = new WebAppContext();


        webApp.setContextPath("/");
        webApp.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        webApp.setResourceBase(webappDirLocation);

        //Parent loader priority is a class loader setting that Jetty accepts.
        //By default Jetty will behave like most web containers in that it will
        //allow your application to replace non-server libraries that are part of the
        //container. Setting parent loader priority to true changes this behavior.
        //Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
        webApp.setParentLoaderPriority(true);

        server.setHandler(webApp);

        server.start();
        server.join();



    }

}
