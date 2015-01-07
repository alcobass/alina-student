package org.hamster.server.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hamster.shared.dto.StudentDTO;

@Entity
@Table(name="student")
public class Student implements AbstractEntity {

	@Column(name="student_id")
	@Id
	private Integer id;
	
	@Column(name="student_first_name")
	private String firstName;
	
	@Column(name="student_last_name")
	private String lastName;
	
	@Column(name="student_course")
	private Integer course;
	
	@Column(name="student_group")
	private Integer group;
	
	
	public Student() {
		super();
	}

	public Student(StudentDTO studentDTO)
	{
		this.id = studentDTO.getId();
		this.firstName = studentDTO.getFirstName();
		this.lastName = studentDTO.getLastName();
		this.course = studentDTO.getCourse();
		this.group = studentDTO.getGroup();
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}
	
	public StudentDTO convertToDTO()
	{
		return new StudentDTO(this.id, this.firstName, this.lastName,this.course, this.group);
	}
	
	/*public void fillFromDTO(StudentDTO studentDTO)
	{
		this.firstName = studentDTO.getFirstName();
		this.lastName = studentDTO.getLastName();
		this.course = studentDTO.getCourse();
		this.group = studentDTO.getGroup();
	}*/
	
	
}
