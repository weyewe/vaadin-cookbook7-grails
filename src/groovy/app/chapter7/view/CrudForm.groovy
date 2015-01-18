package app.chapter7.view
import app.chapter7.bean.Product
import app.chapter7.bean.SecondProduct
import com.vaadin.ui.Button
import com.vaadin.ui.DateField
import com.vaadin.ui.FormLayout
import com.vaadin.ui.Label
import com.vaadin.ui.Panel
import com.vaadin.ui.PasswordField
import com.vaadin.ui.Table
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Window
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.data.Item
import com.vaadin.data.fieldgroup.BeanFieldGroup
import com.vaadin.data.fieldgroup.FieldGroup
import com.vaadin.data.util.BeanItem
import com.vaadin.event.Action
import com.vaadin.event.ItemClickEvent
import com.vaadin.event.Action.Handler
import com.vaadin.event.ItemClickEvent.ItemClickListener
import com.vaadin.event.ShortcutAction.KeyCode
import com.vaadin.ui.Notification
import com.vaadin.data.fieldgroup.PropertyId
import com.vaadin.data.util.BeanItemContainer
import com.vaadin.ui.Notification
import com.vaadin.ui.Notification.Type



class CrudForm extends VerticalLayout {
	@PropertyId("code")
	private TextField codeField = new TextField("Product code")
	
	@PropertyId("name")
	private TextField nameField = new TextField("Product name")
	
	@PropertyId("price")
	private TextField priceField = new TextField("Product price")
	
	private Table table = new Table()
	private BeanItemContainer<SecondProduct> tableContainer 
	private FieldGroup fieldGroup
	private Action actionDelete = new Action("Delete")
	private int code = 1
	private static final int MAX_PAGE_LENGTH = 15 
	
	
	public CrudForm() {
		initTable()
		addComponent( createAddButton() )
		addComponent( table ) 
		table.setPageLength( table.size() )
	
	}
	
	
	private void initTable() {
		tableContainer = new BeanItemContainer<SecondProduct>(SecondProduct.class)
		fillTableContainer( tableContainer ) 
		table.setContainerDataSource( tableContainer)
		table.setSelectable( true ) 
		
		table.addItemClickListener( new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				Notification.show( "I am clicked", Type.ERROR_MESSAGE)
				openProductWindow( event.getItem(), "The window" )
				
//				if( event.isDoubleClick() ) {
//					Notification.show( "Clicked with double click", Type.ERROR_MESSAGE)
//					
//					
//				}
			}
		})
		
//		table.addActionHandler(new Handler() {
//			@Override
//			public void handleAction(Action action, Object sender, Object target) {
//				if( actionDelete == action) {
//					tableContainer.removeItem( target ) 
//					updateTable() 
//				} 
//			}
//			
//			@Override
//			public Action[] getActions(Object target, Object sender) {
//				return [actionDelete]
//			}
//		})
	}
	
	private Button createAddButton() {
		Button button = new Button("Add product")
		button.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				Notification.show( "This is awesome", Type.ERROR_MESSAGE)
				
//				openProductWindow(
//					new BeanItem<SecondProduct>( new SecondProduct(code++) ), 
//					"Add Product"
//				)
			}
			
			
		})
		
		return button 
	}
	
	private void openProductWindow(Item beanItem, String caption) {
		Window window = new Window(caption)
		window.setModal( true )
		
		FormLayout layout = new FormLayout()
		layout.setMargin( true )
		window.setContent( layout )
		
		fieldGroup = new BeanFieldGroup<SecondProduct>(SecondProduct.class)
		fieldGroup.setItemDataSource(beanItem)
		
		String message  = "" 
		for( String s : beanItem.itemPropertyIds ) {
			message += s + " " 
		}
		Notification.show( "itemPropertyIds: " + message, Type.ERROR_MESSAGE)
		
		String message2 = "" 
		for(Object propertyId: fieldGroup.getUnboundPropertyIds()) {
			
			message2 += propertyId + " "
		}
		
		Notification.show( "getUnboundPropertyIds: " + message, Type.ERROR_MESSAGE)
		
		for(Object propertyId: fieldGroup.getUnboundPropertyIds()) {
			if( propertyId.toString() != "metaClass") {
				layout.addComponent( fieldGroup.buildAndBind(propertyId) )
			}
			
		}
//		layout.addComponent( new Label("Name") ) 
//		layout.addComponent( new Label(beanItem.) )
//		layout.addComponent( new Label("Code") )
//		layout.addComponent( new Label("price") )
//		
		layout.addComponent( createOkButton(window) )
		getUI().addWindow(window)
	}
	
	private Button createOkButton(final Window window) {
		Button okButton = new Button("OK")
		okButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					fieldGroup.commit()
					BeanItem<SecondProduct> beanItem =
						(BeanItem<SecondProduct>)fieldGroup.getItemDataSource()
					
					tableContainer.addItem(beanItem.getBean())
					updateTable()
					window.close()
				}catch (Exception e) {
					Notification.show(e.getMessage(), Type.ERROR_MESSAGE)
				}
				
			}
		})
		
		return okButton
	}
	
	
	
	
	
	private void updateTable() {
		if(table.size() > MAX_PAGE_LENGTH) {
			table.setPageLength( MAX_PAGE_LENGTH )
		}else {
			table.setPageLength( table.size() )
		}
		
		table.markAsDirtyRecursive()
	}
	
	private void fillTableContainer (BeanItemContainer<SecondProduct> tableContainer ) {
		tableContainer.addItem( new SecondProduct( code++, "Computer", 599.90))
		tableContainer.addItem( new SecondProduct( code++, "Mobile Phone", 14.90))
		tableContainer.addItem( new SecondProduct( code++, "Tablet", 99.90))
		tableContainer.addItem( new SecondProduct( code++, "Mouse", 0.90))
	}
}
