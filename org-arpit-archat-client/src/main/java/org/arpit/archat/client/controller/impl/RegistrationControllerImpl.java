/**
 * 
 */
package org.arpit.archat.client.controller.impl;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import org.arpit.archat.client.controller.RegistrationController;
import org.arpit.archat.client.controller.RegistrationControllerListener;
import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.view.RegistrationView;
import org.arpit.archat.client.view.RegistrationViewListener;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author arpit
 * 
 */
public class RegistrationControllerImpl extends ControllerImpl implements
		RegistrationController, RegistrationViewListener {

	private final RegistrationView registrationView;
	private FXUser model;
	private final Collection<RegistrationControllerListener> listeners = new LinkedHashSet<>();

	@Inject
	public RegistrationControllerImpl(Injector injector,
			RegistrationView registrationView) {
		super(injector);
		this.registrationView = registrationView;
		this.registrationView.addListener(this);
	}

	private static final String REST_URI = "http://localhost:8080/org-arpit-archat-server/";
	private static final String CREATE = "/users/createUser";

	@Override
	public void activate() {
		registrationView.setModel(getModel());
		registrationView.attach();
	}

	private FXUser getModel() {
		if (this.model == null) {
			model = new FXUser();
			model.setLastModificationDate(new Date());
		}
		return this.model;
	}

	@Override
	public void deactivate() {
		registrationView.detach();
	}

	@Override
	public void onSave() {
		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/org-arpit-archat-server/rest/users/createUser");

		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, model);

		FXUser createdUser = response.getEntity(FXUser.class);
		if(createdUser != null) {
			for (RegistrationControllerListener l : listeners) {
				l.onRegister();
			}
		}
	}

	@Override
	public void addListener(
			RegistrationControllerListener registrationControllerListener) {
		this.listeners.add(registrationControllerListener);
	}

	@Override
	public void removeListener(
			RegistrationControllerListener registrationControllerListener) {
		this.listeners.remove(registrationControllerListener);
	}

	@Override
	public void onCancel() {
		for (RegistrationControllerListener l : listeners) {
			l.onCancel();
		}
	}
}
