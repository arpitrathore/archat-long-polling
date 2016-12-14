/**
 * 
 */
package org.arpit.archat.client.controller.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import javafx.collections.ObservableList;

import org.arpit.archat.client.controller.GroupPopupController;
import org.arpit.archat.client.controller.GroupPopupControllerListener;
import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.dto.FXUserGroup;
import org.arpit.archat.client.service.UserGroupService;
import org.arpit.archat.client.view.GroupPopupView;
import org.arpit.archat.client.view.GroupPopupViewListener;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author arpit
 *
 */
public class GroupPopupControllerImpl extends ControllerImpl implements GroupPopupController, GroupPopupViewListener {

	private final Collection<GroupPopupControllerListener> listeners = new LinkedHashSet<GroupPopupControllerListener>();
	private final GroupPopupView groupPopupView;
	private final UserGroupService userGroupService;

	@Inject
	public GroupPopupControllerImpl(Injector injector, GroupPopupView groupPopupView, UserGroupService userGroupService) {
		super(injector);
		this.groupPopupView = groupPopupView;
		this.groupPopupView.addListener(this);

		this.userGroupService = userGroupService;
	}

	@Override
	public void activate() {
		groupPopupView.attach();
		loadUsers();
	}

	private void loadUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivate() {
		groupPopupView.detach();
	}

	@Override
	public void addListener(GroupPopupControllerListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeListener(GroupPopupControllerListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void onSave(String name, List<FXUser> selectedItems) {
		if(name != null && !name.isEmpty() && selectedItems != null && !selectedItems.isEmpty()){
			FXUserGroup userGroup = new FXUserGroup();
			userGroup.setName(name);
			userGroup.setUsers(new HashSet <FXUser> (selectedItems));
			userGroup.setLastModificationDate(new Date());
			userGroupService.createUserGroup(userGroup);
			for (GroupPopupControllerListener listener : listeners) {
				listener.onGroupSaved();
			}
		}
	}

	@Override
	public void onCancel() {
		for (GroupPopupControllerListener listener : listeners) {
			listener.onGroupCancel();
		}
	}

	@Override
	public void setUsers(ObservableList<FXUser> users) {
		groupPopupView.setUsers(users);
	}
}
