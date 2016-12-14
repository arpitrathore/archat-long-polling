/**
 * 
 */
package org.arpit.archat.client.controller.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.logging.Level;

import org.arpit.archat.client.ARChatApp;
import org.arpit.archat.client.controller.LoginController;
import org.arpit.archat.client.controller.LoginControllerListener;
import org.arpit.archat.client.di.Context;
import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.service.UserService;
import org.arpit.archat.client.view.LoginView;
import org.arpit.archat.client.view.LoginViewListener;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.sun.istack.logging.Logger;

/**
 * @author arpit
 *
 */
public class LoginControllerImpl extends ControllerImpl implements LoginController, LoginViewListener {
	
	private final LoginView loginView;
	private FXUser model;
	private final Collection<LoginControllerListener> listeners = new LinkedHashSet<LoginControllerListener>();
	private final UserService userService;

	@Inject
	public LoginControllerImpl(Injector injector, LoginView loginView, UserService userService) {
		super(injector);
		this.userService = userService;
		
		this.loginView = loginView;
		loginView.addListener(this);
	}
	
	@Override
	public void onClickLogin() {
		final FXUser user = userService.findByUserName(model.getUserName());
		if(user != null){
			if(user.getUserName().equals(model.getUserName()) && user.getPassword().equals(model.getPassword())){
				Logger.getLogger(getClass()).log(Level.ALL, user.getUserName() + " logged in successfully!");
				ARChatApp.getInstance().getStage().setTitle("ARChat - "+user.getFirstName()+" "+user.getLastName());
				Context.setUser(user);
				for (LoginControllerListener l : listeners) {
					l.onSuccessfulLogin();
				}
			}
			else {
				System.out.println("Invalid username or password");
			}
		}
	}

	@Override
	public void activate() {
		this.model = new FXUser();
		loginView.setModel(model);
		loginView.attach();
	}

	@Override
	public void deactivate() {
		loginView.detach();
	}

	public FXUser getModel() {
		return model;
	}

	@Override
	public void addListener(LoginControllerListener loginControllerListener) {
		this.listeners.add(loginControllerListener);
	}

	@Override
	public void removeListener(LoginControllerListener loginControllerListener) {
		this.listeners.remove(loginControllerListener);
	}

	@Override
	public void onClickRegister() {
		for (LoginControllerListener l : listeners) {
			l.onClickRegister();
		}
	}
}
