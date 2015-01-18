package app.chapter7.view

import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory
import com.vaadin.ui.DateField
import com.vaadin.ui.Field

class CustomFieldGroupFactory  extends DefaultFieldGroupFieldFactory{
	@Override
	public <T extends Field> T createField(Class<?> dataType, Class<T> fieldType) {
		if( Date.class.isAssignableFrom( dataType ) ) {
			return (T) new DateField()
		}
		
		return super.createField(dataType, fieldType )
	}

}
