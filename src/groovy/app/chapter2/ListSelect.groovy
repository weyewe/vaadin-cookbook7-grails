package app.chapter2


import app.chapter2.bean.Contact
import app.chapter2.view.ContactViewer
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.data.util.BeanItemContainer

class ListSelect extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        ContactViewer contactViewer = new ContactViewer( createContactContainer() )

        setContent(contactViewer)
    }
	
	private BeanItemContainer<Contact> createContactContainer(){
		BeanItemContainer<Contact> contacts = 
			new BeanItemContainer<>(Contact.class)
		
		contacts.addItem(
			new Contact("Tom", "Smith", "tom.smith@gmail.com")
			)
	
		contacts.addItem(
			new Contact("Bob", "Taylor", "bob.taylor@gmail.com")
		)
		
		contacts.addItem(
			new Contact("Jane", "White", "jane.white@gmail.com")
		)
		
		contacts.addItem(
			new Contact("Suzan", "Lee", "suzan.lee@gmail.com")
		)
		
		return contacts
	}
}