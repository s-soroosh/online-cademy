package com.sarabadani.onlinecademy.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/2/13
 * Time: 3:19 PM
 */
public class Initializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(MvcConfig.class);
        mvcContext.register(InterceptorConfig.class);
        mvcContext.register(FormatterConfig.class);
        mvcContext.register(ViewConfig.class);



        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "dispatcher", new DispatcherServlet(mvcContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

       servletContext.setInitParameter("contextConfigLocation","classpath*:contexts/security.xml");

        servletContext.addListener(ContextLoaderListener.class);




    }


}