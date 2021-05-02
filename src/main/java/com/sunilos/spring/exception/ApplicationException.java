package com.sunilos.spring.exception;

import org.springframework.dao.DataAccessException;

/**
 * Custom application exception
 * 
 * @author Sunil Sahu
 *
 */
public class ApplicationException extends DataAccessException {

	public ApplicationException(String msg) {
		super(msg);
	}

}
