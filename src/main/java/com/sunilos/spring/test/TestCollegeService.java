package com.sunilos.spring.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sunilos.spring.bean.College;
import com.sunilos.spring.service.CollegeServiceInt;

/**
 * Test case of CollegeDAO
 * 
 * @author Sunil Sahu
 *
 */
@Component("collegeTest")
public class TestCollegeService {

	public static ApplicationContext context = null;

	@Autowired
	public CollegeServiceInt service = null;

	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public static void main(String[] args) throws Exception {

		TestCollegeService test = (TestCollegeService) context.getBean("collegeTest");
		// test.testFindByPk();
		test.testAdd();
		// test.testUpdate();
		// test.testSearch();
	}

	public void testSearch() {
		College dto = new College();
		// System.out.println("service->" + service);
		List<College> l = service.search(dto, 0, 0);
		System.out.println("\n--Test college search--");
		System.out.println("Total records: " + l.size());
		int i = 0;
		l.forEach(e -> {
			System.out.print("Name: " + e.getName());
			System.out.print("Address: " + e.getAddress());
			System.out.println();
		});

	}

	public void testAdd() {
		College dto = new College();
		dto.setName("ABC2");
		dto.setAddress("ABC");
		dto.setState("ABC@gmail.com");
		dto.setCity("pass1234");
		Long pk = service.add(dto);
		System.out.println("PK->" + pk);
	}

	public void testUpdate() {
		College dto = new College();
		dto.setId(1);
		dto.setName("ABC");
		dto.setAddress("ABC");
		dto.setState("ABC@gmail.com");
		dto.setCity("pass1234");
		service.update(dto);
		System.out.println("Record os updated");
	}

	public void testFindByPk() {
		College dto = service.get(1);
		System.out.println("Name" + dto.getName());
	}

}
