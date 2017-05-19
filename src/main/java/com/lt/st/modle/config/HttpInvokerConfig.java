package com.lt.st.modle.config;

import java.util.Properties;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.lt.st.modle.service.UserService;

@Configuration
@ComponentScan("com.lt.st.modle.service")
public class HttpInvokerConfig {

//	@Autowired
//	UserService userService;

	@Bean
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
		registration.addUrlMappings("/http/*");
		// registration.setName("http");
		return registration;
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new HttpServlet() {
		}, "/remote");
		registration.addUrlMappings("/remote/*");

		return registration;

	}

	@Bean
	public HttpInvokerServiceExporter httpExportedUserService(UserService service) {
		HttpInvokerServiceExporter ex = new HttpInvokerServiceExporter();
		ex.setService(service);
		ex.setServiceInterface(UserService.class);

		return ex;
	}

	@Bean
	public HandlerMapping httpInvokerMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();

		mappings.setProperty("/user", "httpExportedUserService");
		mapping.setMappings(mappings);

		return mapping;
	}

}
