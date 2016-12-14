/**
 * 
 */
package org.arpit.archat.client.view.javafx;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.view.RegistrationView;
import org.arpit.archat.client.view.RegistrationViewListener;
import org.arpit.archat.client.view.ViewLocation;
import org.arpit.archat.client.view.ViewManager;

import com.google.inject.Inject;

/**
 * @author arpit
 * 
 */
public class FXRegistrationView extends VBox implements RegistrationView {

	private final Collection<RegistrationViewListener> listeners = new LinkedHashSet<>();
	private final ViewManager viewManager;
	private final TextField firstNameTextField = new TextField();
	private final TextField lastNameTextField = new TextField();
	private final TextField userNameTextField = new TextField();
	private final PasswordField passwordTextField = new PasswordField();
	private final TextField birthDateTextField = new TextField();
	private final ChoiceBox<String> genderChoiceBox = new ChoiceBox<String>();
	private final TextField mobileTextField = new TextField();
	private final TextField currentEmailTextField = new TextField();
	private final TextField countryTextField = new TextField();
	private final Button registerButton = new Button("Register");
	private FXUser model;
	private final Button cancelButton = new Button("Cancel");

	@Inject
	public FXRegistrationView(ViewManager viewManager) {
		setPadding(new Insets(15));
		this.viewManager = viewManager;
		initialize();
	}

	private void initialize() {
		Label firstNameLabel = new Label("First Name");
		Label lastNameLabel = new Label("Last Name");
		Label userNameLabel = new Label("Username");
		Label passwordLabel = new Label("Password");
		Label birthDateLabel = new Label("Birth Date");
		Label genderLabel = new Label("Gender");
		Label mobileLabel = new Label("Mobile");
		Label currentEmailLabel = new Label("Current Email");
		Label countryLabel = new Label("Country");

		genderChoiceBox.setItems(FXCollections.observableArrayList(Arrays
				.asList("Male", "Female")));

		registerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for (RegistrationViewListener l : listeners) {
					model.setBirthDate(getDate(birthDateTextField.getText()));
					model.setGender(genderChoiceBox.getSelectionModel().getSelectedItem());
					l.onSave();
				}
			}
		});
		
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for (RegistrationViewListener l : listeners) {
					l.onCancel();
				}
			}
		});

		GridPane gridPane = new GridPane();
		gridPane.setVgap(15);
		gridPane.setHgap(15);

		gridPane.add(firstNameLabel, 0, 0);
		gridPane.add(firstNameTextField, 1, 0);
		gridPane.add(lastNameLabel, 0, 1);
		gridPane.add(lastNameTextField, 1, 1);
		gridPane.add(userNameLabel, 0, 2);
		gridPane.add(userNameTextField, 1, 2);
		gridPane.add(passwordLabel, 0, 3);
		gridPane.add(passwordTextField, 1, 3);
		gridPane.add(birthDateLabel, 0, 4);
		gridPane.add(birthDateTextField, 1, 4);
		gridPane.add(genderLabel, 0, 5);
		gridPane.add(genderChoiceBox, 1, 5);
		gridPane.add(mobileLabel, 0, 6);
		gridPane.add(mobileTextField, 1, 6);
		gridPane.add(currentEmailLabel, 0, 7);
		gridPane.add(currentEmailTextField, 1, 7);
		gridPane.add(countryLabel, 0, 8);
		gridPane.add(countryTextField, 1, 8);
		gridPane.add(registerButton, 0, 9);
		gridPane.add(cancelButton, 1, 9);

		getChildren().add(gridPane);
	}

	private Date getDate(String date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void attachChild(Object subView, ViewLocation location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void detachChild(Object subView) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void attach() {
		viewManager.attach(this, ViewLocation.REGISTER);
	}

	@Override
	public void detach() {
		viewManager.unregisterLocations(this);
		viewManager.detach(this, ViewLocation.REGISTER);
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(RegistrationViewListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(RegistrationViewListener listener) {
		this.listeners.remove(listener);
	}

	@Override
	public void setModel(FXUser user) {
		if (this.model != null) {
			unbindProperties();
			model.setBirthDate(null);
			model.setGender(null);
		}
		this.model = user;
		bindProperties();
	}

	private void bindProperties() {

		userNameTextField.textProperty().bindBidirectional(
				model.userNameProperty());

		passwordTextField.textProperty().bindBidirectional(
				model.passwordProperty());

		firstNameTextField.textProperty().bindBidirectional(
				model.firstNameProperty());

		lastNameTextField.textProperty().bindBidirectional(
				model.lastNameProperty());

		// model.birthDateProperty().bindBidirectional(birthDateTextField.textProperty());

		// model.genderProperty().bindBidirectional(genderChoiceBox.selectionModelProperty());

		mobileTextField.textProperty()
				.bindBidirectional(model.mobileProperty());

		currentEmailTextField.textProperty().bindBidirectional(
				model.currentEmailProperty());

		countryTextField.textProperty().bindBidirectional(
				model.countryProperty());
	}

	private void unbindProperties() {

		userNameTextField.textProperty().unbindBidirectional(
				model.userNameProperty());

		passwordTextField.textProperty().unbindBidirectional(
				model.passwordProperty());

		firstNameTextField.textProperty().unbindBidirectional(
				model.firstNameProperty());

		lastNameTextField.textProperty().unbindBidirectional(
				model.lastNameProperty());

		// model.birthDateProperty().bindBidirectional(birthDateTextField.textProperty());

		// model.genderProperty().bindBidirectional(genderChoiceBox.selectionModelProperty());

		mobileTextField.textProperty().unbindBidirectional(
				model.mobileProperty());

		currentEmailTextField.textProperty().unbindBidirectional(
				model.currentEmailProperty());

		countryTextField.textProperty().unbindBidirectional(
				model.countryProperty());
	}
}
