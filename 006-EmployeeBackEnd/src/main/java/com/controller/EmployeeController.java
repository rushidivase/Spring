package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmployeeService;

@RestController  //It Returns String/data
@RequestMapping("emp-service")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{

		return employeeService.saveEmployee(emp);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping("/{eid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int eid)
	{
		return employeeService.getEmployeeById(eid);
	}
	
	@DeleteMapping("/{eid}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable int eid)
	{
		return employeeService.deleteEmployeeById(eid);
	}
	
	@PutMapping("/")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
	{
		return employeeService.updateEmployee(emp);
		
	}
	
	
	
	
}
