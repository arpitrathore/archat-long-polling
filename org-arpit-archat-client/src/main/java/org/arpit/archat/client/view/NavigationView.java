/**
 * 
 */
package org.arpit.archat.client.view;

import javafx.collections.ObservableList;

import org.arpit.archat.client.HasListeners;
import org.arpit.archat.client.dto.FXMessage;
import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.dto.FXUserGroup;

/**
 * @author arpit
 *
 */
public interface NavigationView extends View, HasListeners<NavigationViewListener> {

	void setUsers(ObservableList<FXUser> users);

	void setGroups(ObservableList<FXUserGroup> groups);

	void setMessages(ObservableList<FXMessage> observableArrayList);

	FXUser getSelectedUser();

	FXUserGroup getSelectedUserGroup();

}
