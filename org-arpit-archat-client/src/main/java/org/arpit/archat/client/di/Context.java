/**
 * 
 */
package org.arpit.archat.client.di;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import org.arpit.archat.client.dto.FXUser;

/**
 * @author arpit
 *
 */
public class Context {

	private static final ObjectProperty<FXUser> user = new SimpleObjectProperty<FXUser>();
	
	public static void setUser(FXUser user) {
		Context.user.setValue(user);
	}

	public static FXUser getUser() {
		return Context.user.get();
	}
	
}
