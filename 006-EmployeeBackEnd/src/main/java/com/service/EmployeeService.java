package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int eid);

	Employee deleteEmployeeById(int eid);

	Employee updateEmployee(Employee emp);

}
