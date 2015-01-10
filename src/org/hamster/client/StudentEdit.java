package org.hamster.client;

import org.hamster.shared.dto.StudentDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class StudentEdit extends Composite {
	
	private Label idLbl = new Label();
	private TextBox firstNameTb = new TextBox();
	private TextBox lastNameTb = new TextBox();
	private TextBox courseTb = new TextBox();
	private TextBox groupTb = new TextBox();
	
	private StudentDTO studentDTO;
	private Command closeCommand;
	  
	public StudentEdit(StudentDTO student, Command closeCommand)
	{
		if (student!=null)
			this.studentDTO = student;
		else this.studentDTO = new StudentDTO();
		this.closeCommand = closeCommand;
		Widget studEdit = createWidget();
		if (student != null)
			fillData(student);
		initWidget(studEdit);
	}
	
	public void save()
	{
		collectData();
		University.getUniversityService().saveStudent(this.studentDTO, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				closeCommand.execute();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error happened while saving!");
				
			}
		});
	}
	
	private Widget createWidget()
	{
		FlexTable ft = new FlexTable();
		ft.setText(0, 0, "ID");
		ft.setText(1, 0, "FIRST NAME");
		ft.setText(2, 0, "SECOND NAME");
		ft.setText(3, 0, "GOURSE");
		ft.setText(4, 0, "GROUP");
		//ft.setText(5, 0, "ACTION");
		
		ft.setWidget(0, 1, idLbl);
		ft.setWidget(1, 1, firstNameTb);
		ft.setWidget(2, 1, lastNameTb);
		ft.setWidget(3, 1, courseTb);
		ft.setWidget(4, 1, groupTb);
		
		PushButton okBtn = new PushButton("OK");
		okBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				save();
			}
		});
		
		PushButton cancelBtn = new PushButton("Cancel");
		cancelBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				StudentEdit.this.closeCommand.execute();
			}
		});
		
		ft.setWidget(5, 0, okBtn);
		ft.setWidget(5, 1, cancelBtn);
		return ft;
	}
	
	private void fillData(StudentDTO student)
	{
		idLbl.setText(student.getId().toString());
		firstNameTb.setText(student.getFirstName());
		lastNameTb.setText(student.getLastName());
		courseTb.setText(student.getCourse().toString());
		groupTb.setText(student.getGroup().toString());
	}
	
	private void collectData()
	{
		studentDTO.setFirstName(firstNameTb.getValue());
		studentDTO.setLastName(lastNameTb.getValue());
		studentDTO.setCourse(Integer.valueOf(courseTb.getValue()));
		studentDTO.setGroup(Integer.valueOf(groupTb.getValue()));
	}

}
