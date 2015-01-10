package org.hamster.shared.dto;

import java.util.List;

public class StudentDTO implements AbstractDTO {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private Integer course;
	
	private Integer group;
	
	private List<DissertationDTO> dissertation;
	
	public StudentDTO()
	{
	
	}
	
	public StudentDTO(Integer id, String firstName, String lastName, Integer course, Integer group)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.group = group;
		this.course = course;
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
	
	public List<DissertationDTO> getDissertation() {
		return dissertation;
	}

	public void setDissertation(List<DissertationDTO> dissertation) {
		this.dissertation = dissertation;
	}

	public String getFullName()
	{
		return firstName + " " + lastName;
	}
}
