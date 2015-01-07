package org.hamster.client;

import java.util.List;

import org.hamster.shared.dto.StudentDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("uni")
public interface UniversityService extends RemoteService {
	
	StudentDTO getStudent(Integer id);
	
	List<StudentDTO> getStudentsList();
	
	void saveStudent(StudentDTO studentDTO);
	
	void deleteStudent(StudentDTO studentDTO);
}
