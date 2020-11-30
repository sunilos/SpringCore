package com.sunilos.spring.dao;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sunilos.spring.bean.UserDTO;

/**
 * User data access object does CRUD operations. Methods propagate unchecked
 * DataAccessException. Hibernate exceptions are converted into
 * DataAccessException by Spring-DAO.
 *
 * If DataAccessException is propagated from method then declarative transaction
 * is rolled back.
 *
 * @version 1.0
 * @since 1 Jan 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@Repository
public class UserDAOJPAImpl implements UserDAOInt {


	private static Logger log = Logger.getLogger(UserDAOJPAImpl.class);

	@Autowired
	private UserJpaRepository japDao= null;

	public UserDTO findByPK(long pk) throws DataAccessException {
		Optional<UserDTO> user = japDao.findById(pk);
		return user.get();
	}

	public UserDTO findByLogin(String login) throws DataAccessException {
		UserDTO user = japDao.findByLogin(login);
		return user;
	}

	public long add(UserDTO dto) throws DataAccessException {
		japDao.save(dto);
		return dto.getId();
	}

	public void update(UserDTO dto) throws DataAccessException {
		japDao.save(dto);
	}

	public UserDTO delete(long id) throws DataAccessException {
		UserDTO dto = findByPK(id);
		japDao.deleteById(id);
		return dto;
	}

	public List<UserDTO> search(UserDTO dto) throws DataAccessException {
		return japDao.findAll();
	}

	public List search(UserDTO dto, int pageNo, int pageSize) throws DataAccessException {

		return japDao.findAll();
/*
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		
		System.out.println("----------------------> I m here " + session);

		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				criteria.add(Restrictions.like("login", dto.getLogin()));
			}
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				criteria.add(Restrictions.like("password", dto.getPassword()));
			}
			if (dto.getGender() != null && dto.getGender().length() > 0) {
				criteria.add(Restrictions.eq("gender", dto.getLastName()));
			}
			if (dto.getDob() != null && dto.getDob().getDate() > 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
			}
			if (dto.getLastLogin() != null && dto.getLastLogin().getTime() > 0) {
				criteria.add(Restrictions.eq("lastLogin", dto.getLastLogin()));
			}
			if (dto.getRoleId() > 0) {
				criteria.add(Restrictions.eq("roleId", dto.getRoleId()));
			}
			if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
				criteria.add(Restrictions.eq("mobileNo", dto.getMobileNo()));
			}

		}

		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}

		list = criteria.list();

		return list;
		*/

	}

}
