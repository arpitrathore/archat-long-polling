/**
 * 
 */
package org.arpit.archat.client.view.javafx;

import java.util.Collection;
import java.util.LinkedHashSet;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.view.LoginView;
import org.arpit.archat.client.view.LoginViewListener;
import org.arpit.archat.client.view.ViewLocation;
import org.arpit.archat.client.view.ViewManager;

import com.google.inject.Inject;

/**
 * @author arpit
 *
 */
public class FXLoginView extends BorderPane implements LoginView{
	
	private final Collection<LoginViewListener> listeners = new LinkedHashSet<>();
	protected final ViewManager viewManager;
	private FXUser model;
	final TextField userNameTextField= new TextField();;
	final PasswordField passwordField= new PasswordField();;
	private Button loginButton = new Button("Login");;
	Button registerButton =new Button("Register");
	
	@Inject
	public FXLoginView(ViewManager viewManager) {
		this.viewManager = viewManager;
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20));
		gridPane.setVgap(30);
		gridPane.setHgap(30);
		
		Label userNameLabel = new Label("Username");
		Label passwordLabel = new Label("Password");

		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (LoginViewListener l : listeners) {
					l.onClickLogin();
				}
			}
		});
		
		registerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for (LoginViewListener l : listeners) {
					l.onClickRegister();
				}
			}
		});
		
		passwordField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for (LoginViewListener l : listeners) {
					l.onClickLogin();
				}
			}
		});
		
		gridPane.add(userNameLabel, 0, 0);
		gridPane.add(userNameTextField, 1, 0);
		gridPane.add(passwordLabel, 0, 1);
		gridPane.add(passwordField, 1, 1);
		gridPane.add(loginButton, 0, 2);
		gridPane.add(registerButton, 1, 2);
		
		setCenter(gridPane);
	}

	@Override
	public void attachChild(Object subView, ViewLocation location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detachChild(Object subView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attach() {
		// Attach this view to its corresponding location
		viewManager.attach(this, ViewLocation.LOGIN);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				userNameTextField.requestFocus();
			}
		});
		
	}

	@Override
	public void detach() {
		viewManager.unregisterLocations(this);
		viewManager.detach(this, ViewLocation.LOGIN);
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModel(FXUser model) {
		if(this.model != null) {
			unbindProperties();
		}
		this.model = model;
		bindProperties();
	}

	private void bindProperties() {
		userNameTextField.textProperty().bindBidirectional(this.model.userNameProperty());
		passwordField.textProperty().bindBidirectional(this.model.passwordProperty());
	}

	private void unbindProperties() {
		userNameTextField.textProperty().unbindBidirectional(this.model.userNameProperty());
		passwordField.textProperty().unbindBidirectional(this.model.passwordProperty());
	}

	@Override
	public void addListener(LoginViewListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(LoginViewListener listener) {
		this.listeners.remove(listener);
	}
	
}
