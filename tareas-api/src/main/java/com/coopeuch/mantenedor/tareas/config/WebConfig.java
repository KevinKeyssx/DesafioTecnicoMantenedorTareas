package com.coopeuch.mantenedor.tareas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Tareas", license = @License(name = "Copyright © 2022 Tareas"), description = "Mantenedor de tareas"))
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("PUT", "POST", "GET", "DELETE", "OPTION", "HEAD").maxAge(3600);
	}

}
