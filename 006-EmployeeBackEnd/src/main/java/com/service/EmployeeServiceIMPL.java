package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.EmployeeRepository;
import com.model.Employee;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<Employee> saveEmployee(Employee emp) {

		if (employeeRepository.existsById(emp.getEid())) {
			return new ResponseEntity<Employee>(employeeRepository.save(emp), HttpStatus.ALREADY_REPORTED);

		} else {
			return new ResponseEntity<Employee>(employeeRepository.save(emp), HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<List<Employee>> getAllEmployees() {

		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(int eid) {

		if (employeeRepository.existsById(eid)) {
			return new ResponseEntity<Employee>(employeeRepository.findById(eid).get(), HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<Employee>(new Employee(), HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public ResponseEntity<Employee> deleteEmployeeById(int eid) {
		
		  Optional<Employee> opt= employeeRepository.findById(eid);
		
		  if(opt.isPresent())
		  {
			  employeeRepository.deleteById(eid);
			  return new ResponseEntity<Employee>(opt.get(), HttpStatus.ACCEPTED);
		  }
		  else
		  {
			  return new ResponseEntity<Employee>(new Employee(), HttpStatus.BAD_REQUEST);
		  }

	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Employee emp) {

		if(employeeRepository.existsById(emp.getEid()))
		{
			return new ResponseEntity<Employee>(employeeRepository.save(emp),HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<Employee>(emp,HttpStatus.CONFLICT);
		}
	
	}

}
