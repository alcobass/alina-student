package org.hamster.server.db.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hamster.server.db.Utils;
import org.hamster.shared.dto.DissertationDTO;
import org.hamster.shared.dto.StudentDTO;

@Entity
@Table(name="student")
public class Student implements AbstractEntity {

	@Column(name="student_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="student_first_name")
	private String firstName;
	
	@Column(name="student_last_name")
	private String lastName;
	
	@Column(name="student_course")
	private Integer course;
	
	@Column(name="student_group")
	private Integer group;
	
	@OneToMany(mappedBy="studentId")
	private List<Dissertation> dissertation;
	
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
	

	public List<Dissertation> getDissertation() {
		return dissertation;
	}

	public void setDissertation(List<Dissertation> dissertation) {
		this.dissertation = dissertation;
	}

	public StudentDTO convertToDTO()
	{
		StudentDTO studentDTO = new StudentDTO(this.id, this.firstName, this.lastName,this.course, this.group);
		List<DissertationDTO> disserList = Utils.convertEntityToDTOList(this.dissertation); 
		studentDTO.setDissertation(disserList);
		return studentDTO;
	}
	
}
