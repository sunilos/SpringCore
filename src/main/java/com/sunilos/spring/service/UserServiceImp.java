package com.sunilos.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunilos.spring.bean.UserDTO;
import com.sunilos.spring.dao.UserDAOInt;

@Service
public class UserServiceImp implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long registerUser(UserDTO dto) {
		long pk = add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public UserDTO delete(long id) {
		UserDTO deletedUser = dao.delete(id);
		return deletedUser;
	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Transactional(readOnly = true)
	public UserDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}

	@Transactional(readOnly = true)
	public List search(UserDTO dto) {
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(String login, String password) {
		UserDTO user = new UserDTO();
		user.setLogin(login);
		user.setPassword(password);

		List list = dao.search(user);
		UserDTO foundUser = null;
		if (list != null && list.size() == 1) {
			foundUser = (UserDTO) list.get(0);
		}
		return foundUser;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean changePassword(Long id, String oldPassword, String newPassword) {
		UserDTO user = dao.findByPK(id);
		if (user != null && oldPassword.equals(user.getPassword())) {
			user.setPassword(newPassword);
			dao.update(user);
			return true;
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean restPassword(String login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean forgetPassword(String login) {
		// TODO Auto-generated method stub
		return false;
	}

}
