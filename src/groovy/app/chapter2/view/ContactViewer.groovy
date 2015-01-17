package app.chapter2.view

import app.chapter2.bean.Contact
import com.vaadin.ui.CustomComponent
import com.vaadin.ui.HorizontalSplitPanel
import com.vaadin.ui.Label
import com.vaadin.ui.ListSelect
import com.vaadin.data.Property.ValueChangeEvent
import com.vaadin.data.Property.ValueChangeListener
import com.vaadin.data.util.BeanItemContainer
import com.google.gwt.safehtml.shared.SafeHtml
import com.vaadin.shared.ui.label.ContentMode
import com.google.gwt.safehtml.shared.SafeHtmlUtils

public class ContactViewer extends CustomComponent{

	public ContactViewer(BeanItemContainer<Contact> contacts) {
		final HorizontalSplitPanel panel  = new HorizontalSplitPanel()
		Label contactLabel = new Label()
		setCompositionRoot( panel  ) 
		
		
		
		
		final ListSelect contactSelect= new ListSelect()
		contactSelect.setSizeFull()
		contactSelect.setImmediate( true ) 
		contactSelect.setContainerDataSource( contacts )
		contactSelect.setItemCaptionPropertyId( "fullName")
		
		contactSelect.addValueChangeListener( new ValueChangeListener() {
			@Override
			public void valueChange( ValueChangeEvent event ) {
				Contact contact = (Contact) event.getProperty().getValue()
				panel.setSecondComponent( createInfoLabel(contact)  )
				contactSelect.focus( )
			}
			
			public Label createInfoLabel(Contact contact) {
				String info = ""
				if( contact != null ) {
					info = "<ul>"
					info += String.format(
						"<li><b>First name:</b> %s </li>",
						contact.getFirstName() )
					info += String.format(
						"<li><b>Last name:</b> %s </li>",
						contact.getLastName() )
					
					info += String.format(
						"<li><b>Email:</b> %s </li>",
						contact.getEmail() )
				}else {
					info = "<div> THere is no contact selected</div>"
				}
				
				SafeHtml safeHtml = SafeHtmlUtils.fromSafeConstant( info )
				
				return new Label( safeHtml.asString(), ContentMode.HTML) 
			}
		})
		
		
		panel.setFirstComponent(contactSelect)
		
		
	}
	
	
}
