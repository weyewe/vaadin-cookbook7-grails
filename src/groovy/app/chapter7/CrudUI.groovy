package app.chapter7

import app.chapter7.view.BoundProductForm
import app.chapter7.view.CrudForm
import app.chapter7.view.GeneratedProductForm
import app.chapter7.view.LoginPanel
import app.demo.layout.AdjustableLayout
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Alignment

class CrudUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
		setContent( new CrudForm() )
		
    }
}
