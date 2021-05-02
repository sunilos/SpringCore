package com.sunilos.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunilos.spring.bean.College;

/**
 * Hibernate implementation of College DAO.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Repository
public class CollegeDAOHibImpl implements CollegeDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger log = Logger.getLogger(CollegeDAOHibImpl.class);

	/**
	 * Adds a College
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public Long add(College dto) {
		log.debug("DAO add Started");
		College c = findByName(dto.getName());
		if (c != null) {
			throw new RuntimeException("College name is already exist.");
		}
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		dto.setId(pk);
		return pk;
	}

	/**
	 * Updates a College
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */

	public void update(College dto) {
		log.debug("DAO update Started");
		College c = findByName(dto.getName());
		if (c != null && c.getId() != dto.getId()) {
			throw new RuntimeException("College name is already exist.");
		}
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("DAO update End");
	}

	/**
	 * Deletes a College
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */

	public College delete(long id) {
		log.debug("DAO delete Started");
		College dto = findByPK(id);
		if (dto != null) {
			sessionFactory.getCurrentSession().delete(dto);
		}
		return dto;
	}

	/**
	 * Finds College by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */

	public College findByPK(long pk) {
		return sessionFactory.getCurrentSession().get(College.class, pk);
	}

	/**
	 * Finds College by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */

	public College findByName(String name) {
		College dto = new College();
		dto.setName(name);
		List<College> list = search(dto);
		dto = (list.size() > 0) ? list.get(0) : null;
		return dto;
	}

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

	public List<College> search(College dto, int pageNo, int pageSize) {

		System.out.println("DAO search Started");

		Criteria c = sessionFactory.getCurrentSession().createCriteria(College.class);

		if (dto.getId() > 0) {
			c.add(Restrictions.eq("id", dto.getId()));
		}
		if (dto.getName() != null && dto.getName().length() > 0) {
			c.add(Restrictions.like("name", dto.getName() + "%"));
		}
		if (dto.getAddress() != null && dto.getAddress().length() > 0) {
			c.add(Restrictions.like("addrsss", dto.getAddress() + "%"));
		}
		if (dto.getState() != null && dto.getState().length() > 0) {
			c.add(Restrictions.like("state", dto.getState() + "%"));
		}
		if (dto.getCity() != null && dto.getCity().length() > 0) {
			c.add(Restrictions.like("city", dto.getCity() + "%"));
		}
		if (dto.getPhoneNo() != null && dto.getPhoneNo().length() > 0) {
			c.add(Restrictions.eq("phoneNo", dto.getPhoneNo()));
		}
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			c.setFirstResult((pageNo - 1) * pageSize);
			c.setMaxResults(pageSize);
		}
		List<College> list = c.list();
		return list;
	}

	/**
	 * Searches Colleges
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */

	public List search(College dto) {
		return search(dto, 0, 0);
	}

}
