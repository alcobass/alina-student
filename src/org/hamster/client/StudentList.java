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
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.PushButton;

public class StudentList extends Composite {
	
	private FlexTable ftMainTable = new FlexTable();
	
	public StudentList()
	{
		initWidget(ftMainTable);
	}
	
	
	private void setData(List<StudentDTO> data)
	{
		ftMainTable.clear(true);
		
		if (data == null)
			return;
		
		int rowcnt = 0;
		
		PushButton addBtn = new PushButton("ADD", new  ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final PopupPanel editPnl = new PopupPanel(false, true);
				Command cancelCommand = new Command() {
					
					@Override
					public void execute() {
						editPnl.hide();
						loadData();
					}
				};
				editPnl.add(new StudentEdit(null, cancelCommand));
				editPnl.center();
				
			}
		});
		ftMainTable.setWidget(0, 0, addBtn);
		rowcnt++;
		
		ftMainTable.setText(rowcnt, 0, "ID");
		ftMainTable.setText(rowcnt, 1, "FIRST NAME");
		ftMainTable.setText(rowcnt, 2, "SECOND NAME");
		ftMainTable.setText(rowcnt, 3, "GOURSE");
		ftMainTable.setText(rowcnt, 4, "GROUP");
		ftMainTable.setText(rowcnt, 5, "DISSERTATION");
		ftMainTable.setText(rowcnt, 6, "ACTION");
		rowcnt++;
	
		for ( final StudentDTO student: data)
		{
			ftMainTable.setText(rowcnt, 0, student.getId().toString());
			ftMainTable.setText(rowcnt, 1, student.getFirstName());
			ftMainTable.setText(rowcnt, 2, student.getLastName());
			ftMainTable.setText(rowcnt, 3, student.getCourse().toString());
			ftMainTable.setText(rowcnt, 4, student.getGroup().toString());
			if (student.getDissertation() != null && !student.getDissertation().isEmpty())
			{
				ftMainTable.setText(rowcnt, 5, student.getDissertation().get(0).getTitle());
			}
			
			PushButton editBtn = new PushButton("Edit");
			editBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					final PopupPanel editPnl = new PopupPanel(false, true);
					Command cancelCommand = new Command() {
						
						@Override
						public void execute() {
							editPnl.hide();
							loadData();
						}
					};
					editPnl.add(new StudentEdit(student, cancelCommand));
					editPnl.center();
				}
			});
			ftMainTable.setWidget(rowcnt, 6, editBtn);
			
			final DialogBox deleteDialogBox = createDeleteDialogBox(student);
			PushButton deleteBtn = new PushButton("Delete");
			deleteBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					deleteDialogBox.center();
					deleteDialogBox.show();
				}
			});
			ftMainTable.setWidget(rowcnt, 7, deleteBtn);
			
			rowcnt++;
		}
		
	}

	
	public void loadData()
	{
		University.getUniversityService().getStudentsList(new AsyncCallback<List<StudentDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				setData(null);
				
			}

			@Override
			public void onSuccess(List<StudentDTO> result) {
				setData(result);
				
			}
		});
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
				loadData();
			}

			@Override
			public void onSuccess(Void result) {
				loadData();
			}
		});
	}

}
