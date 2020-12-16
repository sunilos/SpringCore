package com.sunilos.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Hibetnate persistent object. Binds College to COLLEGE table. It usess
 * hibernate 3.0 annotations configuration instead of .hbm.xml based
 * configuration.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Entity
@Table(name = "College")
public class College {

	@Id
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	@Column(name = "ID")
	protected long id;

	/**
	 * Name of College
	 */
	@Column(name = "NAME", length = 100)
	private String name = null;

	/**
	 * Address of College
	 */
	@Column(name = "ADDRESS", length = 255)
	private String address = null;

	/**
	 * State of College
	 */
	@Column(name = "STATE", length = 20)
	private String state = null;

	/**
	 * City of College
	 */
	@Column(name = "CITY", length = 50)
	private String city = null;

	/**
	 * Phoneno of College
	 */
	@Column(name = "PHONE_NO", length = 15)
	private String phoneNo = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
