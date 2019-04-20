package com.sunilos.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunilos.spring.dao.UserDAO;

/**
 * Use service provides User business operations.
 * 
 * @author Sunil Sahu
 * @Copyright (c) SunilOS Infotech Pvt Ltd
 *
 */

@Service
public class UserService {

	@Autowired
	private UserDAO dao = null;

	public boolean authenticate(String login, String password) {

		dao.get(login, password);

		return true;

	}

}