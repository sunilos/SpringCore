package com.sunilos.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sunilos.spring.bean.Student;

/**
 * Configure bean using Java configuration. Configuration classes must be
 * annotated by @Configuration annotation
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */

@Configuration
public class ConfigContext {

	/**
	 * Configure Student bean. Alternate of @Component and <bean> tag
	 * 
	 * @return
	 */
	@Bean("studentBean")
	public Student studentBean() {
		Student std = new Student();
		std.setFirstName("Ram");
		std.setLastName("Sharma");
		return std;
	}
}
