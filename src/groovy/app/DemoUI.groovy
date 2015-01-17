package app

import app.demo.layout.AdjustableLayout
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout

class DemoUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        
        setContent(new AdjustableLayout() )
    }
}
