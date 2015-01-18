package app.chapter7

import app.chapter7.view.LoginPanel
import app.demo.layout.AdjustableLayout
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Alignment

class SimpleFormUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
		VerticalLayout layout = new VerticalLayout()
        setContent( layout  )
		
		LoginPanel loginPanel = new LoginPanel()
		layout.addComponent( loginPanel) 
		layout.setSizeFull()
		
		layout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER)
		
    }
}
