package com.robsan.config;


import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;


import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.*;
import java.util.EnumSet;


/**
 * Created by lordofeverything on 28/12/14.
 */
@Order(1)
public class MathmasterInitializer implements WebApplicationInitializer {

    final static Logger logger = Logger.getLogger(MathmasterInitializer.class);
    private static final String CONFIG_LOCATION = "com.robsan";
    private static final String MAPPING_URL = "/rest/*";


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        logger.debug("MathmasterInitializer......");

        // The following line is required to avoid having jersey-spring3 registering it's own Spring root context.
        servletContext.setInitParameter("contextConfigLocation", "");

        // Create the 'root' Spring application context
        // WebApplicationContext implementation that looks for Spring
        // configuration in classes annotated with @Configuration annotation.
        // .register[setConfigLocation()] method tells Spring in which package(s) to look for them.
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MathmasterConfig.class);
        // Glue 'root'[WebApplicationContext] to the lifecycle of ServletContext
        servletContext.addListener(new ContextLoaderListener(context));

/*

        FilterRegistration.Dynamic swaggerFilterRegistration = servletContext
                .addFilter("swagger-ui-filter", new StaticContentFilter());
        swaggerFilterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/swagger-ui*/
/*");

        logger.debug("Filter swagger: "+ swaggerFilterRegistration.getServletNameMappings());
*/


        // Register and map the jersey servlet to conteXt.
        ServletRegistration.Dynamic servletRegistration = servletContext
                .addServlet("service-math-servlet", new ServletContainer(new ServiceMathmasterResource()));
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping(MAPPING_URL);


 }


    // Jersey resource initializer
    public static class ServiceMathmasterResource extends ResourceConfig {
        public ServiceMathmasterResource() {

            this.packages(true, CONFIG_LOCATION, "com.wordnik.swagger.jaxrs.listing");
            this.register(JacksonJaxbJsonProvider.class);

        }
    }
}

