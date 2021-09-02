package com.sunilos.spring.bean;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * User POJO class. It is persistent object.
 *
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Entity
@Table(name = "User")

public class UserDTO {

	
	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk", strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)
	protected long id;

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;
	/**
	 * Last Name of User
	 */
	@Column(name = "LAST_NAME", length = 50)
	private String lastName;
	/**
	 * Login of User
	 */
	@Column(name = "LOGIN", length = 50)
	private String login;
	/**
	 * Password of User
	 */
	@Column(name = "PASSWORD", length = 50)
	private String password;
	/**
	 * Date of Birth of User
	 */
	@Column(name = "DOB")
	private Date dob;
	/**
	 * MobielNo of User
	 */
	@Column(name = "MOBILE_NO", length = 15)
	private String mobileNo;
	/**
	 * Role of User
	 */
	@Column(name = "ROLE_ID")
	private long roleId;
	/**
	 * Number of unsuccessful login attempt
	 */
	@Column(name = "UNSUCCESSFUL_LOGIN")
	private int unSuccessfulLogin;
	/**
	 * Gender of User
	 */
	@Column(name = "GENDER", length = 10)
	private String gender;


	/**
	 * IP Address of User from where User was registred.
	 */
	@Column(name = "REGISTERED_IP", length = 20)
	private String registeredIP;
	/**
	 * IP Address of User of his last login
	 */
	@Column(name = "LAST_LOGIN_IP", length = 20)
	private String lastLoginIP;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public int getUnSuccessfulLogin() {
		return unSuccessfulLogin;
	}

	public void setUnSuccessfulLogin(int unSuccessfulLogin) {
		this.unSuccessfulLogin = unSuccessfulLogin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegisteredIP() {
		return registeredIP;
	}

	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

}