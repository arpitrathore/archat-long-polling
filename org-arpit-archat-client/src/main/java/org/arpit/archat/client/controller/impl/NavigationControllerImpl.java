/**
 * 
 */
package org.arpit.archat.client.controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

import org.arpit.archat.client.ARChatApp;
import org.arpit.archat.client.controller.Controller;
import org.arpit.archat.client.controller.GroupPopupController;
import org.arpit.archat.client.controller.GroupPopupControllerListener;
import org.arpit.archat.client.controller.NavigationController;
import org.arpit.archat.client.di.Context;
import org.arpit.archat.client.dto.FXMessage;
import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.dto.FXUserGroup;
import org.arpit.archat.client.service.MessageService;
import org.arpit.archat.client.service.UserGroupService;
import org.arpit.archat.client.service.UserService;
import org.arpit.archat.client.view.NavigationView;
import org.arpit.archat.client.view.NavigationViewListener;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author arpit
 * 
 */
public class NavigationControllerImpl extends ControllerImpl implements NavigationController, NavigationViewListener,
		GroupPopupControllerListener {

	private final NavigationView navigationView;
	private Controller activeController;
	private final UserService userService;
	private final MessageService messageService;
	private final UserGroupService userGroupService;
	private final GroupPopupController groupPopupController;

	private final List<FXMessage> receivedMessages = new ArrayList<FXMessage>();
	private Date lastMessageReceived;

	@Inject
	public NavigationControllerImpl(Injector injector, NavigationView navigationView, GroupPopupController groupPopupController,
			UserService userService, MessageService messageService, UserGroupService userGroupService) {
		super(injector);
		this.userService = userService;
		this.messageService = messageService;
		this.userGroupService = userGroupService;

		this.navigationView = navigationView;
		navigationView.addListener(this);

		this.groupPopupController = groupPopupController;
		this.groupPopupController.addListener(this);

	}

	@Override
	public void activate() {
		navigationView.attach();
		getusersAndGroups();

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							refreshMessages();
						}
					});
				}

			}
		};
		new Thread(runnable).start();

	}

	private void getusersAndGroups() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				final List<FXUser> users = userService.findAll();
				navigationView.setUsers(FXCollections.observableArrayList(users));
				groupPopupController.setUsers(FXCollections.observableArrayList(users));
			}
		});

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				final List<FXUserGroup> users = userGroupService.findAll();
				navigationView.setGroups(FXCollections.observableArrayList(users));
			}
		});

	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}

	/**
	 */
	@Override
	public void onClickEnter(String text) {
		final FXUser selectedUser = navigationView.getSelectedUser();
		final FXUserGroup selectedUserGroup = navigationView.getSelectedUserGroup();
		if (selectedUser != null && selectedUserGroup != null) {
			throw new IllegalArgumentException();
		}

		final FXMessage message = new FXMessage();
		message.setText(text);
		message.setReceiver(selectedUser);
		message.setUserGroup(selectedUserGroup);
		message.setSender(Context.getUser());
		message.setLastModificationDate(new Date());
		messageService.createMessage(message);
	}

	private void refreshMessages() {
		final FXUser selectedUser = navigationView.getSelectedUser();
		final FXUserGroup selectedUserGroup = navigationView.getSelectedUserGroup();
		if (selectedUser != null && selectedUserGroup != null) {
			throw new IllegalArgumentException();
		}
		if (selectedUser != null) {
			List<FXMessage> messages = messageService.findBysenderAndReceiver(Context.getUser().getId(), selectedUser.getId());
			navigationView.setMessages(FXCollections.observableArrayList(messages));
		} else if (selectedUserGroup != null) {
			List<FXMessage> messages = messageService.findByGroup(selectedUserGroup.getId(), lastMessageReceived);
			if (messages != null && !messages.isEmpty()) {
				receivedMessages.addAll(messages);
				lastMessageReceived = new Date();
				blinkStage();
			}
			navigationView.setMessages(FXCollections.observableArrayList(receivedMessages));
		}
	}

	private void blinkStage() {
		final Stage stage = ARChatApp.getInstance().getStage();
		if (stage.isIconified()) {
			stage.toFront();
		}
	}

	@Override
	public void onClickGroup() {
		groupPopupController.activate();
	}

	@Override
	public void onGroupSaved() {
		groupPopupController.deactivate();
		getusersAndGroups();
	}

	@Override
	public void onGroupCancel() {
		groupPopupController.deactivate();
	}

}
