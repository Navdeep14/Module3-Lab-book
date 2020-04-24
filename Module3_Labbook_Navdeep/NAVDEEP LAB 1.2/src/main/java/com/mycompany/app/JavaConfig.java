package com.mycompany.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@ComponentScan("com.mycompany.app")
@PropertySource("classpath:values.properties")

public class JavaConfig {

	
}