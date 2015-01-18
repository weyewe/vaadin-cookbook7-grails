package app.chapter8



import app.chapter8.listener.AddUserListener
import app.demo.layout.AdjustableLayout

import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Button
import com.vaadin.ui.Label
import com.vaadin.ui.TextField
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Alignment

import multiple.ui.application.User
import multiple.ui.application.UserService


class GrailsVaadinUI extends UI {
	
	TextField txtName = new TextField("Name : ")
	VerticalLayout layout = new VerticalLayout() 
	
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		layout.setMargin(true ) 
		setContent(layout) 
		
		layout.addComponent( txtName ) 
		Button btnAdd = new Button("Add")
		layout.addComponent( btnAdd ) 
		btnAdd.addClickListener( new AddUserListener() )
		
		List<User> users=  Grails.get(UserService).allUsers()
		for(User user : users) {
			layout.addComponent( new Label(user.name ) ) 
		}
	}
}
