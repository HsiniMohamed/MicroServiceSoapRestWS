package org.sid.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.sid.web.CompteRestJaxRSAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	//@Bean
	ResourceConfig resourceConfig() {
		ResourceConfig jerseyServlet=new ResourceConfig();
		jerseyServlet.register(CompteRestJaxRSAPI.class);
		return jerseyServlet;
	}
}
