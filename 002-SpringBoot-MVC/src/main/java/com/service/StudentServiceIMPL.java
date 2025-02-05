package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentRepository;
import com.model.Student;

@Service
public class StudentServiceIMPL implements StudentService{

	@Autowired
	private StudentRepository repo;
	
	public void saveStudent(Student stu) {
		
		System.out.println("Student in Service:"+stu);
		repo.save(stu);
	}


	public List<Student> loginCheck(String username, String password) {
		
		   if(username.equals("admin") && password.equals("1234"))
		   {
			   return repo.findAll();
		   }
		   else
		   {
			   return new ArrayList<Student>();
		   }
	}


	public List<Student> deleteById(int sid) {
	
		repo.deleteById(sid);
		return repo.findAll();
	}


	public Student getStudentById(int sid) {
		
		return repo.findById(sid).get();
	}


	public List<Student> updateStudent(Student stu) {
		
		repo.save(stu);
		return repo.findAll();
	}


	public List<Student> searchData(String record) {
		
		
		return repo.findAll();
	}


	public List<Student> refreshPage() {
		return repo.findAll();	
		}
}
