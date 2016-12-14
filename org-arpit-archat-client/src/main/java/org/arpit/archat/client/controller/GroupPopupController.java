/**
 * 
 */
package org.arpit.archat.client.controller;

import javafx.collections.ObservableList;

import org.arpit.archat.client.HasListeners;
import org.arpit.archat.client.dto.FXUser;

/**
 * @author arpit
 *
 */
public interface GroupPopupController extends Controller, HasListeners<GroupPopupControllerListener> {

	void setUsers(ObservableList<FXUser> observableArrayList);

}
