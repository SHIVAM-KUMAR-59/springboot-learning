package org.shivam;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.Servlet;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws LifecycleException
    {
        System.out.println( "Hello World!" );

        // Create the object for tomcat
        Tomcat tomcat = new Tomcat();

        // Maping our servlet with the routes
        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet");

        // The default port for tomcat is 8080
        tomcat.start();

        // Ask the tomcat server to wait
        tomcat.getServer().await();

    }
}
