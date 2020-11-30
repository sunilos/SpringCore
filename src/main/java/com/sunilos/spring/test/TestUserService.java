package com.sunilos.spring.test;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sunilos.spring.bean.UserDTO;
import com.sunilos.spring.service.UserServiceInt;

@Component("userTest")
public class TestUserService {

	public static ApplicationContext context = null;

	@Autowired
	public UserServiceInt service = null;

	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public static void main(String[] args) throws Exception {

		TestUserService test = (TestUserService) context.getBean("userTest");
		// test.testFindByPk();
		//test.testAdd();
		//test.testUpdate();
		test.testSearch();
	}

	public void testSearch() {
		UserDTO dto = new UserDTO();
		System.out.println("service->" + service);
		List<UserDTO> l = service.search(dto);
		l.forEach(e -> {
			System.out.print("First Name " + e.getFirstName());
			System.out.print("Last Name " + e.getLastName());
			System.out.println();
		});
		System.out.println(l);
	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("ABC");
		dto.setLastName("ABC");
		dto.setLogin("ABC@gmail.com");
		dto.setPassword("pass1234");
		dto.setDob(new java.sql.Date((new Date()).getTime()));
		dto.setMobileNo("1234567890");
		dto.setRoleId(1);
		dto.setUnSuccessfulLogin(1);
		dto.setGender("M");
		long pk = service.add(dto);
		System.out.println("PK->" + pk);
	}

	public void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("ABC");
		dto.setLastName("ABC");
		dto.setLogin("ABC@gmail.com");
		dto.setPassword("pass1234");
		dto.setDob(new java.sql.Date((new Date()).getTime()));
		dto.setMobileNo("1234567890");
		dto.setRoleId(1);
		dto.setUnSuccessfulLogin(1);
		dto.setGender("M");
		service.update(dto);
		System.out.println("Record os updated");
	}

	public void testFindByPk() {
		UserDTO dto = service.findByPK(1);
		System.out.println("First Name " + dto.getFirstName());
		System.out.println("Last Name " + dto.getLastName());
	}

}
