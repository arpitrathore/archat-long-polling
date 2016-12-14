/**
 * 
 */
package org.arpit.archat.client.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

import org.arpit.archat.common.dto.IAbstractEntity;

/**
 * @author Arpit.Rathore
 *
 */
@XmlRootElement(name = "abstractEntity")
public class FXAbstractEntity implements IAbstractEntity{
	
	private LongProperty id = new SimpleLongProperty();
	private ObjectProperty<Date> lastModificationDate = new SimpleObjectProperty<Date>();


	public Long getId() {
		return id.get();
	}

	public void setId(Long id) {
		this.id.set(id);
	}

	public Date getLastModificationDate() {
		return lastModificationDate.get();
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate.set(lastModificationDate);
	}
}
