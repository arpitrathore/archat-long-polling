/**
 * 
 */
package org.arpit.archat.client.view;

import javafx.collections.ObservableList;

import org.arpit.archat.client.HasListeners;
import org.arpit.archat.client.dto.FXUser;

/**
 * @author arpit
 *
 */
public interface GroupPopupView extends View, HasListeners<GroupPopupViewListener> {

	void setUsers(ObservableList<FXUser> users);

}
