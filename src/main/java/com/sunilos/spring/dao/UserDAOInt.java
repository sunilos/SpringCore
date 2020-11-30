package com.sunilos.spring.dao;

import java.util.List;

import com.sunilos.spring.bean.UserDTO;

/**
 * User DAO Interface provides abstract methods of CRUD operations. CRUD
 * operations are implemented by Hibernate and JDBC.
 *
 * All methods propagate unchecked DataAccessException. It is a generic
 * exception translation provided by Spring-DAO.
 *
 * If DataAccessException is propagated from a method then declarative
 * transaction is rolled back by Spring AOP.
 *
 * @version 1.0
 * @since 1 Jan 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

public interface UserDAOInt {

	/**
	 * Adds a user
	 *
	 * @param dto
	 */
	public long add(UserDTO dto);

	/**
	 * Updates a user
	 *
	 * @param dto
	 * @return
	 */
	public void update(UserDTO dto);

	/**
	 * Deletes a user and return deleted user data
	 *
	 * @param id
	 * @return
	 */
	public UserDTO delete(long id);

	/**
	 * Finds user by login id
	 *
	 * @param login
	 *            : get parameter
	 * @return dto
	 */
	public UserDTO findByLogin(String login);

	/**
	 * Finds user by primary key ID
	 *
	 * @param pk
	 *            : get parameter
	 * @return dto
	 */
	public UserDTO findByPK(long pk);

	/**
	 * Searches users with help of passed parameters
	 *
	 * @param dto
	 */
	public List search(UserDTO dto);

	/**
	 * Searches users with help of passed parameters and apply pagination
	 *
	 * @return list : List of Users
	 * 
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 */
	public List search(UserDTO dto, int pageNo, int pageSize);

}