package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.model.Employee;

public interface EmployeeService {

	ResponseEntity<Employee> saveEmployee(Employee emp);

	ResponseEntity<List<Employee>> getAllEmployees();

	ResponseEntity<Employee> getEmployeeById(int eid);

	ResponseEntity<Employee> deleteEmployeeById(int eid);

	ResponseEntity<Employee> updateEmployee(Employee emp);

}
