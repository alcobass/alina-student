package org.hamster.server.dao;

import java.util.List;

import org.hamster.server.db.Utils;
import org.hamster.server.db.entities.Student;
import org.hamster.shared.dto.StudentDTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {
	@SuppressWarnings("unchecked")
	static public List<StudentDTO> getStudentsList(){
		SessionFactory sf = Utils.getSessionFactory();
		Session session = sf.openSession();
		
		Query q = session.createQuery("from Student");
		List<Student> list = (List<Student>)q.list();
		
		return Utils.convertEntityToDTOList(list);
		
	}
	
	static public void saveStudent(StudentDTO studentDTO)
	{
		SessionFactory sf = Utils.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Student student = new Student(studentDTO);
		session.update(student);
		tx.commit();
	}
	
	static public void deleteStudent(StudentDTO studentDTO)
	{
		SessionFactory sf = Utils.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Student student = new Student(studentDTO);
		session.delete(student);
		tx.commit();
	}

}
