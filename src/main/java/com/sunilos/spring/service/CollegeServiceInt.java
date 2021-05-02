package com.sunilos.spring.service;

import java.util.List;

import com.sunilos.spring.bean.College;

/**
 * College Service interface.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public interface CollegeServiceInt {

	/**
	 * Adds a College
	 * 
	 * @param dto
	 * @return
	 */
	public Long add(College dto);

	/**
	 * Updates a College
	 * 
	 * @param dto
	 */
	public void update(College dto);

	/**
	 * Deletes a College
	 * 
	 * @param id
	 * @return
	 */
	public College delete(long id);

	/**
	 * Searches Colleges
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<College> search(College dto, int pageNo, int pageSize);

	/**
	 * Gets a College by its ID
	 * 
	 * @param id
	 * @return
	 */
	public College get(long id);

	/**
	 * Gets a College by its name.
	 * 
	 * @param name
	 * @return
	 */
	public College get(String name);
}
