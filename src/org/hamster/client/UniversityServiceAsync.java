package org.hamster.client;

import java.util.List;

import org.hamster.shared.dto.StudentDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UniversityServiceAsync {
	
	void getStudent(Integer input, AsyncCallback<StudentDTO> callback);
	
	void getStudentsList( AsyncCallback<List<StudentDTO>> callback);

	void saveStudent(StudentDTO studentDTO, AsyncCallback<Void> callback);

	void deleteStudent(StudentDTO studentDTO, AsyncCallback<Void> callback);

}
