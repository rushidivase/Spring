package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Student;

public class StudentDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertStudent(Student stu) {
		String query = "insert into student values(?,?,?)";
		jdbcTemplate.update(query,stu.getSid(),stu.getName(),stu.getMarks());
		System.out.println("Record insered..!");
		
	}

	public Map<String, Object> getRecordById(int i) {
		String query = "select * from student where sid=?";
		return jdbcTemplate.queryForMap(query,i);
	}

	public List<Map<String, Object>> getAllRecord() {
		String query = "select * from student";
		return jdbcTemplate.queryForList(query);
	}

	public void deleteById(int i) {
		String query= "delete from student where sid=?";
		jdbcTemplate.update(query,i);
		System.out.println("Record Deleted..!");
		
	}

	public void updateStudent(Student stu) {
		String query = "update student set name=?, marks=? where sid=?";
		jdbcTemplate.update(query, stu.getName(), stu.getMarks(), stu.getSid());
		System.out.println("Record Updated..!");
		
	}



}
