package com.sunilos.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sunilos.spring.bean.UserDTO;

//@Repository
public class UserDAOJDBCImpl implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDTO dto) {

		String sql = "INSERT INTO USER (ID,FIRST_NAME,LAST_NAME,LOGIN,PASSWORD,DOB,MOBILE_NO,ROLE_ID,UNSUCCESSFUL_LOGIN,GENDER) VALUES(?,?,?,?,?,?,?,?,?,?)";

		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps	   = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, dto.getId());
				ps.setString(2, dto.getFirstName());
				ps.setString(3, dto.getLastName());
				ps.setString(4, dto.getLogin());
				ps.setString(5, dto.getPassword());
				ps.setDate(6, dto.getDob());
				ps.setString(7, dto.getMobileNo());
				ps.setLong(8, dto.getRoleId());
				ps.setInt(9, dto.getUnSuccessfulLogin());
				ps.setString(10, dto.getGender());
				return ps;
			}
		}, holder);

		long pk = holder.getKey().intValue();

		return pk;
	}

	public void update(UserDTO dto) {

		String sql = "UPDATE USER SET FIRST_NAME =?, LAST_NAME =?,LOGIN =?,PASSWORD =?,DOB =?,MOBILE_NO =?,ROLE_ID =?,UNSUCCESSFUL_LOGIN =?,GENDER =? WHERE ID =?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword(), dto.getDob(), dto.getMobileNo(), dto.getRoleId(), dto.getUnSuccessfulLogin(),
				dto.getGender(),dto.getId());
		

	}

	public UserDTO delete(long id) {
		UserDTO user = findByPK(id);
		String sql = "DEELET FROM USER WHERE ID =? ";
		Object[] params = { id };
		int i = jdbcTemplate.update(sql, params);
		return user;
	}

	public UserDTO findByLogin(String login) {
		String sql = "SELECT ID,FIRST_NAME,LAST_NAME,LOGIN,PASSWORD,DOB,MOBILE_NO,ROLE_ID,UNSUCCESSFUL_LOGIN,GENDER FROM USER WHERE LOGIN =? ";
		Object[] params = { login };
		UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
		return user;
	}

	public UserDTO findByPK(long pk) {
		String sql = "SELECT ID,FIRST_NAME,LAST_NAME,LOGIN,PASSWORD,DOB,MOBILE_NO,ROLE_ID,UNSUCCESSFUL_LOGIN,GENDER FROM USER WHERE ID =? ";
		Object[] params = { pk };
		UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
		return user;
	}

	public List search(UserDTO dto) {
		String sql = "SELECT ID,FIRST_NAME,LAST_NAME FROM USER ";
		Object[] params = {};
		List l = jdbcTemplate.query(sql, new UserMapper());
		return l;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		String sql = "SELECT ID,FIRST_NAME,LAST_NAME FROM USER LIMIT " + pageNo + "," + pageSize;
		List l = jdbcTemplate.query(sql, new UserMapper());
		return l;
	}

}
