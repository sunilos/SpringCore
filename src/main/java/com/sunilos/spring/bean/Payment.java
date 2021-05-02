package com.sunilos.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Payment bean
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */

@Component
public class Payment {

	/**
	 * Balance is initialized using @Value annotation
	 */
	@Value(value = "100")
	double balance = 0;

	public double getBalance() {

		return balance;

	}

	public void setBalance(double balance) {

		this.balance = balance;

	}

	public double makePayment(double amt) {

		balance = balance - amt;

		return balance;

	}

	public double diposit(double amt) {

		balance = balance + amt;

		return balance;

	}

}