package com.sunilos.spring.bean;

public class Customer {

	/**
	 * Customer bean
	 * 
	 * @author Sunil Sahu
	 * @Copyright (c) SunilOS Infotech Pvt Ltd
	 *
	 */

	private String firstName = null;

	private String lastName = null;

	private Account account = null;

	public Customer() {

	}

	public Customer(Account account) {

		this.account = account;

	}

	public String getFirstName() {

		return firstName;

	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;

	}

	public String getLastName() {

		return lastName;

	}

	public void setLastName(String lastName) {

		this.lastName = lastName;

	}

	public Account getAccount() {

		return account;

	}

	public void setAccount(Account account) {

		this.account = account;

	}

	/**
	 * Life cycle init method
	 */
	public void init() {
		System.out.println("Customer: init lifecycle method");
	}

	/**
	 * Life cycle destroy method
	 */
	public void destroy() {
		System.out.println("Customer: destroy lifecycle method");
	}

}