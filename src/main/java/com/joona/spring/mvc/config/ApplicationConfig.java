package com.joona.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.joona.spring.mvc.components", "com.joona.spring.mvc.db.connector"})
@EnableWebMvc
public class ApplicationConfig {

}
