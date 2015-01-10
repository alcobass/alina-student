package org.hamster.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class University implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final static UniversityServiceAsync universityService = GWT
			.create(UniversityService.class);
	

	public static UniversityServiceAsync getUniversityService() {
		return universityService;
	}


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		StudentList studentList = new StudentList();
		RootPanel.get().add(studentList);
		studentList.loadData();
	}
	
		
}
