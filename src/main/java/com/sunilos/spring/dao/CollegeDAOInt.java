package com.sunilos.spring.dao;

import java.util.List;

import com.sunilos.spring.bean.College;

/**
 * Data Access Object of College
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public interface CollegeDAOInt {

	/**
	 * Adds a College
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public Long add(College dto);

	/**
	 * Updates a College
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(College dto);

	/**
	 * Deletes a College
	 * 
	 * @param id
	 * @throws DatabaseException
	 */
	public College delete(long id);

	/**
	 * Finds College by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public College findByPK(long pk);

	/**
	 * Finds College by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public College findByName(String name);

	/**
	 * Searches Colleges
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(College dto);

	/**
	 * Searches Colleges with pagination
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DatabaseException
	 */
	public List search(College dto, int pageNo, int pageSize);

}
