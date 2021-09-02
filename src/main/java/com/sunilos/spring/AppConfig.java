package com.sunilos.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sunilos.spring.bean.Student;

/**
 * ##Java based configuration
 * 
 * #Class annotated by @Configuration annotation defines configuration class.
 * 
 * #Annotation @Bean is used to define the class in configuration class.
 * 
 * #Annotation @ComponentScan scans all annotated classes from base package and
 *                register with spring container.
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */

@Configuration
// @ComponentScan annotation scans all annotated classes from base package
// and register with spring container.
//@ComponentScan(basePackages = { "com.sunilos.spring" })
public class AppConfig {

	/**
	 * Configure Student bean.
	 */
	@Bean("studentBean")
	public Student studentBean() {
		Student std = new Student();
		std.setFirstName("Ram");
		std.setLastName("Sharma");
		return std;
	}
}
