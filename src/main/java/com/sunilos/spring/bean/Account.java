package com.sunilos.spring.bean;

/**
 * Account bean
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */

public class Account {

	private String number = null;

	private String type = null;

	private double balance = 100;

	public double getBalance() {

		return balance;

	}

	public void diposit(double balance) {

		this.balance += balance;

	}

	public void withdraw(double balance) {

		this.balance -= balance;

	}

	public String getNumber() {

		return number;

	}

	public void setNumber(String number) {

		this.number = number;

	}

	public String getType() {

		return type;

	}

	public void setType(String type) {

		this.type = type;

	}

}