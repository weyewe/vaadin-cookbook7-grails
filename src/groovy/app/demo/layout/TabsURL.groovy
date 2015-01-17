package app.demo.layout

import com.vaadin.ui.Component
import com.vaadin.ui.Label
import com.vaadin.ui.TabSheet
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent
import com.vaadin.ui.TabSheet.SelectedTabChangeListener
import com.vaadin.server.Sizeable.Unit

class TabsURL  extends TabSheet{
	private static final  tabNames = [
		"Home",
		"Contractors",
		"Customers",
		"Employee",
		"Help"
	]
	
	public TabsURL() {
		createTabs( tabNames )
		addSelectedTabChangeListener( new SelectedTabChangeListener() {
			@Override
			public void selectedTabChange(SelectedTabChangeEvent event) {
				String selectedTabName = event.getTabSheet().getSelectedTab().getCaption()
				
				
				UI.getCurrent().getPage().setUriFragment(selectedTabName)
			}
		})
	}
	
	
	public void selectTab() {
		String fragment = UI.getCurrent().getPage().getUriFragment()
		if(fragment == null ) {
			setSelectedTab(0)
			return
		}
		
		int counter = 0 
		for( String tabName : tabNames) {
			if( fragment.toLowerCase()  == tabName.toLowerCase() ) {
				setSelectedTab( counter)
				return 
			}
			counter++
		}
		
		setSelectedTab(0)
		
	}
	
	private void createTabs(tabNames) {
		for( String tabName : tabNames) {
			VerticalLayout layout = new VerticalLayout()
			layout.setCaption(tabName)
			layout.addComponent(
				new Label("<h1>" + tabName + "</h1")
				)
			layout.setHeight(400, Unit.PIXELS)
			addComponent( layout ) 
		}
	}
	
	
}
