package com.main;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.model.Student;

public class TestMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDao dao = context.getBean(StudentDao.class);
		System.out.println("Application Running Properly..!");

		// insertStudent(dao);

		// getStudentById(dao);

		// getAllRecords(dao);

		// dao.deleteById(101);

		// updateById(dao);

	}

	private static void updateById(StudentDao dao) {
		Student stu = new Student();
		stu.setSid(102);
		stu.setName("A");
		stu.setMarks(100);
		dao.updateStudent(stu);
	}

	private static void getAllRecords(StudentDao dao) {
		List<Map<String, Object>> sList = dao.getAllRecord();
		System.out.println(sList);
	}

	private static void getStudentById(StudentDao dao) {
		Map<String, Object> stu = dao.getRecordById(101);
		System.out.println(stu);
	}

	private static void insertStudent(StudentDao dao) {
		Student stu = new Student();
		stu.setSid(102);
		stu.setName("Isha");
		stu.setMarks(88);

		dao.insertStudent(stu);
	}
}
