package org.hamster.client;

import java.util.List;

import org.hamster.shared.dto.StudentDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StudentList extends Composite {
	
	public StudentList()
	{
		FlexTable ft = getStudList();
		initWidget(ft);
	}
	
//	private FlexTable GetInfo()
//	{
//		final FlexTable ft = new FlexTable();
//		ft.setText(0, 0, "Student name:");
//		universityService.getStudent(1, new AsyncCallback<StudentDTO>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(StudentDTO result) {
//				ft.setText(0, 1, result.getFirstName() + " " + result.getLastName());
//				
//			}
//			
//		});
//		
//		return ft;
//
//	}
	
	private FlexTable getStudList()
	{
		final FlexTable ftList = new FlexTable();
		University.getUniversityService().getStudentsList(new AsyncCallback<List<StudentDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<StudentDTO> result) {
				int rowcnt = 0;
				ftList.setText(rowcnt, 0, "ID");
				ftList.setText(rowcnt, 1, "FIRST NAME");
				ftList.setText(rowcnt, 2, "SECOND NAME");
				ftList.setText(rowcnt, 3, "GOURSE");
				ftList.setText(rowcnt, 4, "GROUP");
				ftList.setText(rowcnt, 5, "ACTION");
				rowcnt++;
			
				for ( final StudentDTO student: result)
				{
					ftList.setText(rowcnt, 0, student.getId().toString());
					ftList.setText(rowcnt, 1, student.getFirstName());
					ftList.setText(rowcnt, 2, student.getLastName());
					ftList.setText(rowcnt, 3, student.getCourse().toString());
					ftList.setText(rowcnt, 4, student.getGroup().toString());
					
					PushButton editBtn = new PushButton("Edit");
					editBtn.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							final PopupPanel editPnl = new PopupPanel(false, true);
							Command cancelCommand = new Command() {
								
								@Override
								public void execute() {
									editPnl.hide();
									
								}
							};
							editPnl.add(new StudentEdit(student, cancelCommand));
							editPnl.center();
						}
					});
					ftList.setWidget(rowcnt, 5, editBtn);
					
					final DialogBox deleteDialogBox = createDeleteDialogBox(student);
					PushButton deleteBtn = new PushButton("Delete");
					deleteBtn.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							deleteDialogBox.center();
							deleteDialogBox.show();
							
//							StudentDelete studentDelete = new StudentDelete(student);
//							studentDelete.show();
						}
					});
					ftList.setWidget(rowcnt, 6, deleteBtn);
					
					rowcnt++;
				}
				
			}
		});
		
		return ftList;
	}
	
	private DialogBox createDeleteDialogBox(final StudentDTO studentDTO)
	{
		final DialogBox deleteDialogBox = new DialogBox();
		deleteDialogBox.setText("Delete the student");
		
		FlexTable ft = new FlexTable();
		deleteDialogBox.add(ft);
		ft.setText(0, 0, "Do you really want to delete this student:");
		ft.setText(1, 0, studentDTO.getFullName());
		
		PushButton deleteBtn = new PushButton("DELETE");
		deleteBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				deleteStudent(studentDTO);
				deleteDialogBox.hide();
			}
		});
		
		ft.setWidget(2, 0, deleteBtn);
		
		PushButton closeBtn = new PushButton("CLOSE");
		closeBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				deleteDialogBox.hide();
			}
		});
		ft.setWidget(2, 1, closeBtn);
		
		return deleteDialogBox;
	}
	
	private void deleteStudent(StudentDTO studentDTO)
	{
		University.getUniversityService().deleteStudent(studentDTO, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				University.getUniversityService();
				
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
