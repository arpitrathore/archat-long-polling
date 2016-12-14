/**
 * 
 */
package org.arpit.archat.client.controller.impl;

import org.arpit.archat.client.controller.ARChatController;
import org.arpit.archat.client.controller.Controller;
import org.arpit.archat.client.controller.LoginController;
import org.arpit.archat.client.controller.LoginControllerListener;
import org.arpit.archat.client.controller.NavigationController;
import org.arpit.archat.client.controller.RegistrationController;
import org.arpit.archat.client.controller.RegistrationControllerListener;
import org.arpit.archat.client.view.ARChatView;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author arpit
 * 
 */
public class ARChatControllerImpl extends ControllerImpl implements
		ARChatController, LoginControllerListener, RegistrationControllerListener {

	private final ARChatView rootView;
	private final LoginController loginController;
	private final NavigationController navigationController;
	private final RegistrationController registrationController;
	private Controller activeController;

	@Inject
	public ARChatControllerImpl(Injector injector, ARChatView rootView,
			LoginController loginController,
			NavigationController navigationController,
			RegistrationController registrationController) {
		super(injector);
		this.rootView = rootView;
		this.loginController = loginController;
		loginController.addListener(this);
		this.navigationController = navigationController;

		this.registrationController = registrationController;
		this.registrationController.addListener(this);
	}

	@Override
	public void activate() {
		rootView.attach();
		activate(loginController);
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSuccessfulLogin() {
		activate(navigationController);
	}

	@Override
	public void onClickRegister() {
		activate(registrationController);
	}

	private void activate(Controller controller) {
		if (activeController != null) {
			activeController.deactivate();
		}
		activeController = controller;
		activeController.activate();
	}

	@Override
	public void onRegister() {
		activate(loginController);
	}

	@Override
	public void onCancel() {
		activate(loginController);
	}

}
