/**
 * 
 */
package org.arpit.archat.client.dto;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

import org.arpit.archat.common.dto.IUserGroup;

/**
 * @author Arpit.Rathore
 *
 */
@XmlRootElement(name = "userGroup")
public class FXUserGroup extends FXAbstractEntity implements IUserGroup{

	private StringProperty name = new SimpleStringProperty();
	private SetProperty<FXUser> users = new SimpleSetProperty<FXUser>();
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public Set<FXUser> getUsers() {
		return users.get();
	}
	public void setUsers(Set<FXUser> users) {
		this.users.setValue(FXCollections.observableSet(users));
	}
}
