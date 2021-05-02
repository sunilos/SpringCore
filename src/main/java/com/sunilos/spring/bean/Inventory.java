package com.sunilos.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Inventory bean is registred with container using name "inventory"
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */
@Component("inventory")
public class Inventory {

	/**
	 * 
	 * Initialize stock by value 100
	 * 
	 */
	@Value(value = "100")
	int stock = 0;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int sold(int qty) {
		stock -= qty;
		return stock;
	}

}