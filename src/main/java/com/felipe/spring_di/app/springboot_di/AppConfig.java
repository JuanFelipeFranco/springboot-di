package com.felipe.spring_di.app.springboot_di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

}
