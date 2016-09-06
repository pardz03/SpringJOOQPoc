package com.poc.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * based on
 * https://www.mkyong.com/spring-mvc/gradle-spring-4-mvc-hello-world-example-annotation/
 * @author joliveros
 *
 */
public class WebAppInitializer implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {  
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
        ctx.register(SpringConfig.class,PersistenceContext.class);  
        ctx.setServletContext(servletContext);    
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        dynamic.addMapping("/");  
        dynamic.setLoadOnStartup(1); 
	}
}