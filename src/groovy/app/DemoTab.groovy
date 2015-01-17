package app

import app.demo.layout.AdjustableLayout
import app.demo.layout.TabsURL
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.server.Page.UriFragmentChangedEvent
import com.vaadin.server.Page.UriFragmentChangedListener
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout

class DemoTab extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
		final TabsURL tabsURL = new TabsURL()
		setContent( tabsURL )
		tabsURL.selectTab()
		
		getPage().addUriFragmentChangedListener( new UriFragmentChangedListener() {
			@Override
			public void uriFragmentChanged(UriFragmentChangedEvent event) {
				tabsURL.selectTab()
			}
		})
    }
}
