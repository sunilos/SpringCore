package com.sunilos.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.sunilos.spring.bean.Customer;
import com.sunilos.spring.bean.User;

/**
 * 
 * It tests XML based spring container configuration and creates BeanFactory
 * container object.
 * 
 * Beans are configured using ApplicationContext.xml file.
 * 
 * It demonstrates bean creation by <bean> XML tag, @Component annotation
 * 
 * It shown Explicit and Implicit dependency injection
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */

public class TestBeanFactory {

	// public static BeanFactory context = null;
	public static BeanFactory context = null;

	static {

		context = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	}

	/**
	 * Beans are configured using <bean> tag and depicts setter injection
	 */
	public static void testUserBean() {

		System.out.println("---Testing User Bean---");

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

		System.out.println("---Testing Customer Bean---");

		Customer customer = (Customer) context.getBean("customerBean");

		System.out.println("Account balance :" + customer.getAccount().getBalance());

	}

	public static void main(String[] args) {

		testUserBean();
		testCustomerBean();
	}

}