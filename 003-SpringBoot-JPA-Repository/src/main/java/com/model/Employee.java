package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int eid;
	private String ename;
	private double salary;
	private long mono;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getMono() {
		return mono;
	}

	public void setMono(long mono) {
		this.mono = mono;
	}
	
	public Employee()
	{
		
	}
	

	public Employee(int eid, String ename, double salary, long mono) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.mono = mono;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", mono=" + mono + "]";
	}

}
