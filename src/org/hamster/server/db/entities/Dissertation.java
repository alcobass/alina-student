package org.hamster.server.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hamster.shared.dto.AbstractDTO;
import org.hamster.shared.dto.DissertationDTO;

@Entity
@Table
public class Dissertation implements AbstractEntity{
	
	@Id
	@Column(name="dst_id")
	private Integer id;
	
	@Column(name="dst_title")
	private String title;
	
	@Column(name="dst_student_id")
	private Integer studentId;
	
	@Column(name="dst_teacher_id")
	private Integer teacherId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public AbstractDTO convertToDTO() {
		DissertationDTO dissertationDTO = new DissertationDTO();
		dissertationDTO.setTitle(this.title);
		return dissertationDTO;
	}
	
}
