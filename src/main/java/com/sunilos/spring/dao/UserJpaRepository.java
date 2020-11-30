package com.sunilos.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunilos.spring.bean.UserDTO;

/**

 *
 * @version 1.0
 * @since 1 Jan 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */

@Repository
public interface UserJpaRepository extends JpaRepository<UserDTO, Long>{
	public UserDTO findByLogin(String login);
}