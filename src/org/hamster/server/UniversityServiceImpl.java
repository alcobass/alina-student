package org.hamster.server;

import java.util.ArrayList;
import java.util.List;

import org.hamster.client.UniversityService;
import org.hamster.server.dao.StudentDAO;
import org.hamster.server.db.Utils;
import org.hamster.server.db.entities.Student;
import org.hamster.shared.dto.StudentDTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UniversityServiceImpl extends RemoteServiceServlet implements
		UniversityService {
	
	public StudentDTO getStudent(Integer id) /*throws IllegalArgumentException*/ {
		
		//SessionFactory sf = Utils.getSessionFactory();
				//Session session = sf.openSession();
				//Query q = session.createQuery("from Student");
				//List<Student> list = q.list();
				
				//Query q = session.createQuery("from Teacher");
				//List<Teacher> list = q.list();
				
				//Query q = session.createQuery("from Dissertation");
				//List<Dissertation> list = q.list();
		
		SessionFactory sf = Utils.getSessionFactory();
		Session session = sf.openSession();
		
		Student student = (Student)session.get(Student.class, id);
		return student.convertToDTO();
	
	}
	
	public List<StudentDTO> getStudentsList(){
		
		return StudentDAO.getStudentsList();
		
	}

	@Override
	public void saveStudent(StudentDTO studentDTO) {
		
		StudentDAO.saveStudent(studentDTO);
	}

	@Override
	public void deleteStudent(StudentDTO studentDTO) {
		StudentDAO.deleteStudent(studentDTO);
	};

}
