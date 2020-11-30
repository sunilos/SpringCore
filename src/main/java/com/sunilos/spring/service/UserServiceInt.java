package com.sunilos.spring.service;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.sunilos.spring.bean.UserDTO;

/**
 * Service of User
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public interface UserServiceInt {

	public long add(UserDTO dto);

	/**
	 * Register a user
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * 
	 */
	public long registerUser(UserDTO dto);

	/**
	 * Update a User
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	public void update(UserDTO dto);

	/**
	 * Delete a user
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	public UserDTO delete(long id);

	/**
	 * Find user by login
	 * 
	 * @param login
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public UserDTO findByLogin(String login);

	/**
	 * Find user by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public UserDTO findByPK(long pk);

	/**
	 * Search Users
	 * 
	 * @return list : List of Users
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	public List search(UserDTO dto);

	/**
	 * Change Password By pk
	 * 
	 * @param pk
	 *            ,oldPassword,newPassword : get parameter
	 */
	public boolean changePassword(Long id, String oldPassword, String newPassword);

	/**
	 * User Authentication
	 * 
	 * @return dto : Contains User's information
	 */
	public UserDTO authenticate(String login, String password);

	/**
	 * Reset Password of User with auto generated Password
	 * 
	 * @return boolean : true if success otherwise false
	 * @param login
	 *            : User Login
	 */
	public boolean restPassword(String login);

	/**
	 * Send the password of User to his Email
	 * 
	 * @return boolean : true if success otherwise false
	 * @param login
	 *            : User Login
	 */
	public boolean forgetPassword(String login);

}