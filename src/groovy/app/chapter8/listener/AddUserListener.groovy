package app.chapter8.listener

import app.chapter8.GrailsVaadinUI

import com.vaadin.ui.Label
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener 

import multiple.ui.application.User

import com.vaadin.grails.Grails

import multiple.ui.application.UserService

import com.vaadin.ui.UI

class AddUserListener implements ClickListener {

	@Override
	public void buttonClick(ClickEvent event) {
		GrailsVaadinUI ui = (GrailsVaadinUI) UI.getCurrent()
		 
		String value = ui.txtName.getValue()
		println("The value:  " + value )
		UserService userService = Grails.get(UserService)
	
		
		User user = userService.add(value) 
		
		ui.layout.addComponent( new Label(user.name) ) 
		
	}
	

}
