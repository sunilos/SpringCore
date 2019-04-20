package com.sunilos.spring.dao;

import org.springframework.stereotype.Repository;

import com.sunilos.spring.bean.User;

/**
 * Use DAO provides User CRUD operations with database
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */
@Repository
public class UserDAO {

	public User get(String login, String password) {

		System.out.println("Datavase CRUD operations");

		return null;

	}

}