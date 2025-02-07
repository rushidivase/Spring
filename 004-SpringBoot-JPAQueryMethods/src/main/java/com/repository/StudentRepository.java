package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findBySname(String sname);
	
	public List<Student> findBySnameAndAge(String sname, int age);
	
	public List<Student> findByAgeBetween(int age1, int age2);
	
	public List<Student> findBySnameLike(String sname);
	
	public List<Student> findByAgeOrderBySnameDesc(int age);
	
}
