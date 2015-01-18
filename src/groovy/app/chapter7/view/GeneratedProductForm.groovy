package app.chapter7.view

import app.chapter7.bean.Product
import com.vaadin.ui.Button
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

class GeneratedProductForm extends FormLayout {
	public GeneratedProductForm() {
		setSizeUndefined()
		setMargin( true ) 
		
		FieldGroup fieldGroup = new BeanFieldGroup<Product>(Product.class)
		fieldGroup.setFieldFactory( new CustomFieldGroupFactory() )
		
		fieldGroup.setItemDataSource( new BeanItem<Product>(
			
			new Product( 1, "Tablet", 299.99)
			))
		
		for( Object propertyId : fieldGroup.getUnboundPropertyIds() ) {
			addComponent( fieldGroup.buildAndBind( propertyId) )
		}
	}
}
