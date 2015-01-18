package app.chapter6


import app.chapter6.validator.PinValidator
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.ui.TextField
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.data.util.BeanItemContainer

class ValidationUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout()
		layout.setMargin( true  )
		setContent(layout)
		
		TextField txt = new TextField("Enter PIN Code")
		txt.setImmediate( true ) 
		layout.addComponent( txt ) 
		
		txt.addValidator( new PinValidator() ) 
	}

	
}