/**
 * 
 */
package org.arpit.archat.client.di.modules;

import javafx.stage.Stage;

import org.arpit.archat.client.ARChatApp;
import org.arpit.archat.client.controller.ARChatController;
import org.arpit.archat.client.controller.GroupPopupController;
import org.arpit.archat.client.controller.LoginController;
import org.arpit.archat.client.controller.NavigationController;
import org.arpit.archat.client.controller.RegistrationController;
import org.arpit.archat.client.controller.impl.ARChatControllerImpl;
import org.arpit.archat.client.controller.impl.GroupPopupControllerImpl;
import org.arpit.archat.client.controller.impl.LoginControllerImpl;
import org.arpit.archat.client.controller.impl.NavigationControllerImpl;
import org.arpit.archat.client.controller.impl.RegistrationControllerImpl;
import org.arpit.archat.client.service.MessageService;
import org.arpit.archat.client.service.UserGroupService;
import org.arpit.archat.client.service.UserService;
import org.arpit.archat.client.service.impl.MessageServiceImpl;
import org.arpit.archat.client.service.impl.UserGroupServiceImpl;
import org.arpit.archat.client.service.impl.UserServiceImpl;
import org.arpit.archat.client.view.ARChatView;
import org.arpit.archat.client.view.GroupPopupView;
import org.arpit.archat.client.view.LoginView;
import org.arpit.archat.client.view.NavigationView;
import org.arpit.archat.client.view.RegistrationView;
import org.arpit.archat.client.view.Root;
import org.arpit.archat.client.view.ViewManager;
import org.arpit.archat.client.view.impl.ViewManagerImpl;
import org.arpit.archat.client.view.javafx.FXARChatView;
import org.arpit.archat.client.view.javafx.FXGroupPopupView;
import org.arpit.archat.client.view.javafx.FXLoginView;
import org.arpit.archat.client.view.javafx.FXNavigationView;
import org.arpit.archat.client.view.javafx.FXRegistrationView;

/**
 * @author arpit
 *
 */
public class ARChatModule extends HeadlessModule {

	@Override
	protected void configure() {
		super.configure();
		
		//Extra
		bind(ViewManager.class).to(ViewManagerImpl.class);
		bind(Stage.class).annotatedWith(Root.class).toInstance(ARChatApp.getInstance().getStage());
		
		//Controllers
		bind(ARChatController.class).to(ARChatControllerImpl.class);
		bind(LoginController.class).to(LoginControllerImpl.class);
		bind(NavigationController.class).to(NavigationControllerImpl.class);
		bind(RegistrationController.class).to(RegistrationControllerImpl.class);
		bind(GroupPopupController.class).to(GroupPopupControllerImpl.class);
		
		//Views
		bind(ARChatView.class).to(FXARChatView.class);
		bind(LoginView.class).to(FXLoginView.class);
		bind(NavigationView.class).to(FXNavigationView.class);
		bind(RegistrationView.class).to(FXRegistrationView.class);
		bind(GroupPopupView.class).to(FXGroupPopupView.class);
		
		//Service
		bind(UserService.class).to(UserServiceImpl.class);
		bind(MessageService.class).to(MessageServiceImpl.class);
		bind(UserGroupService.class).to(UserGroupServiceImpl.class);
	}
}
