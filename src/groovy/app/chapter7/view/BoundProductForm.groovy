package app.chapter7.view
import app.chapter7.bean.Product
import com.vaadin.ui.Button
import com.vaadin.ui.DateField
import com.vaadin.ui.FormLayout
import com.vaadin.ui.Panel
import com.vaadin.ui.PasswordField
import com.vaadin.ui.TextField
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.data.fieldgroup.BeanFieldGroup
import com.vaadin.data.fieldgroup.FieldGroup
import com.vaadin.data.util.BeanItem
import com.vaadin.event.ShortcutAction.KeyCode
import com.vaadin.ui.Notification
import com.vaadin.data.fieldgroup.PropertyId;



class BoundProductForm extends FormLayout {
	private TextField code = new TextField("Product code")
	
	@PropertyId("name")
	private TextField nameField = new TextField("Product name")
	
	@PropertyId("price")
	private TextField priceField = new TextField("Product price")
	
	@PropertyId("date")
	private DateField dateField = new DateField("Product date")
	
	
	public BoundProductForm() {
		setSizeUndefined()
		setMargin( true ) 
		FieldGroup fieldGroup = new BeanFieldGroup<Product>(Product.class)
		
		fieldGroup.setItemDataSource( new BeanItem<Product> (
				new Product( 1, "Tablet", 29.99)
			) )
		
		fieldGroup.bindMemberFields( this ) 
		
		addComponent( code)
		addComponent( nameField ) 
		addComponent( priceField ) 
		addComponent( dateField )
	}
	
}
