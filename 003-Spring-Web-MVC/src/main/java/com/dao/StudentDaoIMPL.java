package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student;

@Repository
public class StudentDaoIMPL implements StudentDao {

	@Autowired
	private SessionFactory factory;

	public void saveStudent(Student stu) {
		System.out.println("Student in Dao:" + stu);
		Session session = factory.openSession();
		session.save(stu);
		session.beginTransaction().commit();

	}

	public List<Student> getAllStudent() {
		Session session = factory.openSession();
		Query q = session.createQuery("from Student");
		return q.getResultList();
	}

	public List<Student> deleteById(int sid) {
		Session session = factory.openSession();
		Student stu = session.get(Student.class, sid);
		session.delete(stu);
		session.beginTransaction().commit();
		return getAllStudent();
	}

}
