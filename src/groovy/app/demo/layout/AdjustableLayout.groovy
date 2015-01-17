package app.demo.layout;

import com.google.gwt.safehtml.shared.SafeHtml
import com.vaadin.ui.Component
import com.vaadin.ui.HorizontalSplitPanel
import com.vaadin.ui.Label
import com.vaadin.ui.RichTextArea
import com.vaadin.ui.Table
import com.vaadin.ui.Tree
import com.vaadin.ui.VerticalSplitPanel
import com.google.gwt.safehtml.shared.SafeHtmlUtils
import com.vaadin.data.Item
import com.vaadin.shared.ui.label.ContentMode
import com.vaadin.server.Sizeable.Unit

public class AdjustableLayout extends HorizontalSplitPanel {
	private static final String LIPSUM = "LOREM BLA balaefawe ahjl eahl jfleajl "
	
	public AdjustableLayout() {
		setFirstComponent( createMenu() )
		setSecondComponent( createContentPanel() )
		setSplitPosition(10, Unit.PERCENTAGE)
		setSizeFull()
	}
	
	private Tree createMenu() {
		Tree menu = new Tree()
		for( int i = 1; i < 6; i++) {
			String item = "item " + i
			String childItem = "subitem" + i
			
			menu.addItem(item)
			menu.addItem( childItem )
			menu.setParent( childItem, item)
			menu.setChildrenAllowed( childItem, false)
		}
		
		return menu 
	}
	
	private Component createContentPanel() {
		VerticalSplitPanel contentPanel = new VerticalSplitPanel()
		contentPanel.setFirstComponent( createEditorPanel() )
		contentPanel.setSecondComponent( createTable() )
		contentPanel.setSplitPosition( 80, Unit.PERCENTAGE)
		return contentPanel 
	}
	
	private Component createEditorPanel() {
		SafeHtml safeHtml = SafeHtmlUtils.fromSafeConstant(
				"<b>Help</b>" + LIPSUM
			)
		
		HorizontalSplitPanel editorPanel = new HorizontalSplitPanel()
		RichTextArea editor = new RichTextArea()
		editor.setSizeFull()
		editor.setValue(LIPSUM)
		editorPanel.setFirstComponent( editor )
		editorPanel.setSecondComponent( 
			new Label( safeHtml.asString(), ContentMode.HTML)
			)
		
		
		editorPanel.setSplitPosition(80, Unit.PERCENTAGE)
	
		return editorPanel 
	}
	
	private Table createTable() {
		Table table = new Table()
		
		table.addContainerProperty("Name", String.class, null) 
		table.addContainerProperty("Value", String.class, null )
	  
		
		Object newItemId = table.addItem()
		Item row1 = table.getItem(newItemId)
		row1.getItemProperty("Name").setValue("Sirius")
		row1.getItemProperty("Value").setValue("Banzai")
		
		
		
		table.setSizeFull()
		return table 
	}
	
	
}
