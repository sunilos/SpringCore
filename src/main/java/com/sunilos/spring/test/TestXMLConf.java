package com.sunilos.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunilos.spring.bean.Customer;
import com.sunilos.spring.bean.Order;
import com.sunilos.spring.bean.Student;
import com.sunilos.spring.bean.User;

/**
 * 
 * It tests XML based spring container configuration and creates
 * ApplicationContext container object.
 * 
 * Beans are configured using ApplicationContext.xml and AppConfig.class files.
 * 
 * It demonstrates bean creation by <bean> XML tag, @Component annotation
 * 
 * It shown Explicit and Implicit dependency injection
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */

public class TestXMLConf {

	public static ApplicationContext context = null;
	// public static BeanFactory context = null;

	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/**
	 * Beans are configured using <bean> tag and depicts setter injection
	 */
	public static void testUserBean() {

		System.out.println("\n---Testing User Bean---");

		// get User bean

		User bean = (User) context.getBean("userBean");

		// Print container properties of bean
		System.out.println("##Bean properties");

		System.out.println("1: Bean contains: " + context.containsBean("userBean"));

		System.out.println("2: Type of bean: " + context.getType("userBean"));

		System.out.println("3: is bean singlton: " + context.isSingleton("userBean"));

		// print first name value
		System.out.println("Bean initialized values");
		System.out.println("First Name: " + bean.getFirstName());
		System.out.println("Role: " + bean.getRole().getName());

	}

	/**
	 * Beans are configured using <bean> tag and depicts constructor injection
	 */

	public static void testCustomerBean() {

		System.out.println("\n---Testing Customer Bean---");

		Customer customer = (Customer) context.getBean("customerBean");

		System.out.println("Account balance :" + customer.getAccount().getBalance());

	}

	/**
	 * Beans are configured using @Component tag and depicts auto wiring
	 * injection
	 */

	public static void testOrderBean() {

		System.out.println("\n---Testing Order Bean---");

		Order o = (Order) context.getBean("order");

		o.placeOrder(2, 5);

		System.out.println(o.getAmount());

	}

	/**
	 * Beans are configured using @Configuration and @Bean annotation in
	 * AppConfig class
	 */
	public static void testStudentBean() {
		System.out.println("\n---Testing Student Bean---");
		Student std = (Student) context.getBean("studentBean");
		System.out.println("First Name: " + std.getFirstName());
		System.out.println("Last Name: " + std.getLastName());
	}

	/**
	 * Test User Service
	 */

	public static void testUserService() {

		// UserService service = (UserService) context.getBean("userService");
		// System.out.println("Authenticate :" + service.authenticate("SunilOS",
		// "sunilOS"));

	}

	public static void main(String[] args) {

		testUserBean();
		testCustomerBean();
		testOrderBean();
		testStudentBean();
		testUserService();
	}

}