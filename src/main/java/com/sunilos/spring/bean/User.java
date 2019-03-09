package com.sunilos.spring.bean;

/**
 * User bean. Role bean is injected in User bean
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */

public class User {

	private String firstName = null;

	private String lastName = null;

	/**
	 * 
	 * Setter injection
	 * 
	 */

	private Role role = null;

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

	public Role getRole() {

		return role;

	}

	public void setRole(Role role) {

		this.role = role;

	}

}