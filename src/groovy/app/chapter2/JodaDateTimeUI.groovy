package app.chapter2


import app.chapter2.bean.Contact
import app.chapter2.bean.Post
import app.chapter2.view.ContactViewer
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.data.fieldgroup.FieldGroup
import com.vaadin.data.util.BeanItem
import com.vaadin.data.util.BeanItemContainer
import org.joda.time.DateTime

class JodaDateTimeUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Post post = new Post()
		String label = "I really need that stuff"
		post.setText( label ) 
		DateTime created = DateTime.now() 
		post.setCreated( created ) 
		
		BeanItem<Post> postBean = new BeanItem<Post>(post)
		FieldGroup fieldGroup  = new FieldGroup(postBean )
        setContent(contactViewer)
    }
	
}