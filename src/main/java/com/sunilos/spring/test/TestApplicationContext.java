package com.sunilos.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunilos.spring.bean.Customer;
import com.sunilos.spring.bean.Order;
import com.sunilos.spring.bean.Student;
import com.sunilos.spring.bean.User;
import com.sunilos.spring.service.UserService;

/**
 * 
 * Creates ApplicationContext and get a bean and print bean properties
 *
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */

public class TestApplicationContext {

	public static ApplicationContext context = null;
	// public static BeanFactory context = null;

	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// context = new XmlBeanFactory(new
		// ClassPathResource("applicationContext.xml"));
	}

	public static void testUserBean() {

		System.out.println("---Testing User Bean---");

		// get User bean

		User bean = (User) context.getBean("userBean");

		// Print container properties of bean
		System.out.println("##Bean properties");

		System.out.println("Bean contains: " + context.containsBean("userBean"));

		System.out.println("Type of bean: " + context.getType("userBean"));

		System.out.println("is Singlton: " + context.isSingleton("userBean"));

		// print first name value

		System.out.println(bean.getFirstName());

		System.out.println(bean.getRole().getName());

	}

	/**
	 * Test customer bean
	 */

	public static void testCustomerBean() {

		System.out.println("---Testing Customer Bean---");

		Customer customer = (Customer) context.getBean("customerBean");

		System.out.println("Account balance :" + customer.getAccount().getBalance());

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

	/**
	 * Test User Service
	 */

	public static void testUserService() {

		UserService service = (UserService) context.getBean("userService");
		System.out.println("Authenticate :" + service.authenticate("SunilOS", "sunilOS"));

	}

	public static void main(String[] args) {

		testUserBean();
		testCustomerBean();
		testOrderBean();
		testStudentBean();
		testUserService();
	}

}
