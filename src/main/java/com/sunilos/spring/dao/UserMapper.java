package com.sunilos.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sunilos.spring.bean.UserDTO;

public class UserMapper implements RowMapper<UserDTO> {

	public UserDTO mapRow(ResultSet rs, int arg1) throws SQLException {

		// "SELECT
		// ID,FIRST_NAME,LAST_NAME,LOGIN,PASSWORD,DOB,MOBILE_NO,ROLE_ID,UNSUCCESSFUL_LOGIN,GENDER
		// FROM USER WHERE ID =?""
		UserDTO user = new UserDTO();
		user.setId(rs.getLong(1));
		user.setFirstName(rs.getString(2));
		user.setLastName(rs.getString(3));
		//user.setLogin(rs.getString(4));
		//user.setPassword(rs.getString(5));
		//user.setDob(rs.getDate(6));
		//user.setMobileNo(rs.getString(7));
		//user.setRoleId(rs.getLong(8));
		//user.setUnSuccessfulLogin(rs.getInt(9));
		//user.setGender(rs.getString(10));

		return user;
	}

}
