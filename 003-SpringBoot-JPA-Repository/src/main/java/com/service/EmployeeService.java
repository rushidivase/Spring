package com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public void check() {
		// System.out.println("Check Method Called..!");

		// saveSingleEmployee();

		// saveMultipleRecords();

		// getAllRecords();

		// getById();

		// getMultipleRecords();

		// countRecords();

		//existsById();
		
		//deleteById();
		
		//deleteMultipleRecords();
		
		//It deletes all the records Available in DB
		repo.deleteAll();
	}

	private void deleteMultipleRecords() {
		List<Integer> ids= Arrays.asList(102,103);
		repo.deleteAllById(ids);
		System.out.println("Records Deleted...!");
	}

	private void deleteById() {
		repo.deleteById(101);
		System.out.println("Record Deleted..!");
	}

	private void existsById() {
		boolean flag = repo.existsById(101);
		if (flag) {
			System.out.println("Record is Available");
		} else {
			System.out.println("Record is Not Available");
		}
	}

	private void countRecords() {
		long count = repo.count();
		System.out.println("Total Records:" + count);
	}

	private void getMultipleRecords() {
		// 101,103,104
		List<Integer> ids = Arrays.asList(101, 103, 104);
		List<Employee> eList = repo.findAllById(ids);
		System.out.println(eList);
	}

	private void getById() {
		Employee e1 = repo.findById(101).get();
		System.out.println(e1);
	}

	private void getAllRecords() {
		List<Employee> eList = repo.findAll();
		System.out.println(eList);
	}

	private void saveMultipleRecords() {
		Employee e1 = new Employee(102, "Mahesh", 80000, 987654345678l);
		Employee e2 = new Employee(103, "Mahesh", 80000, 987654345678l);
		Employee e3 = new Employee(104, "Mahesh", 80000, 987654345678l);
		Employee e4 = new Employee(105, "Mahesh", 80000, 987654345678l);
		Employee e5 = new Employee(106, "Mahesh", 80000, 987654345678l);

		List<Employee> eList = Arrays.asList(e1, e2, e3, e4, e5);

		repo.saveAll(eList);
	}

	private void saveSingleEmployee() {
		Employee e1 = new Employee();
		e1.setEid(101);
		e1.setEname("Akash");
		e1.setMono(87654345678l);
		e1.setSalary(70000);
		repo.save(e1);
	}
}
