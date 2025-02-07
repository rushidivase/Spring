package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Student;
import com.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	public void check() {
		
		// findByAgeOrderBySname();

		// getSnameLike();

		// findByAgeBetween();

		// getBySnameAndAge();

		// getStudentByName();

		// System.out.println("Check method is running..!");
	}

	private void findByAgeOrderBySname() {
		List<Student> sList = repo.findByAgeOrderBySnameDesc(20);
		System.out.println(sList);
	}

	private void getSnameLike() {
		List<Student> sList = repo.findBySnameLike("A%");
		System.out.println(sList);
	}

	private void findByAgeBetween() {
		List<Student> sList = repo.findByAgeBetween(19, 22);
		System.out.println(sList);
	}

	private void getBySnameAndAge() {
		List<Student> sList = repo.findBySnameAndAge("John Doe", 18);
		System.out.println(sList);
	}

	private void getStudentByName() {
		List<Student> sList = repo.findBySname("John Doe");
		System.out.println(sList);
	}
}
