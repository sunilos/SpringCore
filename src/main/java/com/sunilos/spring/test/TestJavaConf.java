package com.sunilos.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sunilos.spring.AppConfig;
import com.sunilos.spring.bean.Order;
import com.sunilos.spring.bean.Student;

/**
 * It tests XML based spring container configuration and creates
 * ApplicationContext container object.
 * 
 * Beans are configured using AppConfig.java file.
 * 
 * Beans are configured using Java Configuration. All classes annotated
 * by @Configuration annotation are used to configure IOC container.
 * 
 * It test Java based configuration
 *
 * @author Sunil Sahu
 *
 */

public class TestJavaConf {

	// AppConfig contains bean configuration
	private static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	public static void main(String[] args) throws Exception {

		testOrderBean();
		testStudentBean();
	}

	/**
	 * Test Order bean
	 */

	public static void testOrderBean() {

		System.out.println("---Testing Order Bean---");

		Order o = (Order) context.getBean("order");

		o.placeOrder(2, 5);

		System.out.println(o.getAmount());

	}

	public static void testStudentBean() {

		System.out.println("---Testing Student Bean---");
		Student std = (Student) context.getBean("studentBean");
		System.out.println("First Name: " + std.getFirstName());
		System.out.println("Last Name: " + std.getLastName());
	}

}