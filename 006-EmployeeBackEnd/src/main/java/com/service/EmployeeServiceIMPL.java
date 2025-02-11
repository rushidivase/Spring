package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeRepository;
import com.model.Employee;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee emp) {
		
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int eid) {
	
		return employeeRepository.findById(eid).get();
	}

	@Override
	public Employee deleteEmployeeById(int eid) {
		Employee emp = employeeRepository.findById(eid).get();
		employeeRepository.deleteById(eid);
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		
		return employeeRepository.save(emp);
	}
	
}
