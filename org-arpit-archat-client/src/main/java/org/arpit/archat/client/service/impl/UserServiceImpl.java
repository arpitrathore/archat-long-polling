/**
 * 
 */
package org.arpit.archat.client.service.impl;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.service.UserService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

/**
 * @author Arpit.Rathore
 *
 */
public class UserServiceImpl extends GenericServiceImpl implements UserService {
	private final String FIND_ALL_URL = GENERIC_URL + "/users/findAll";
	private final String FIND_BY_USERNAME_URL = GENERIC_URL
			+ "/users/findByUsername";
	private final GenericType<List<FXUser>> FXUSER_LIST_TYPE = new GenericType<List<FXUser>>() {
	};
	private final GenericType<FXUser> FXUSER_TYPE = new GenericType<FXUser>() {
	};

	@Override
	public List<FXUser> findAll() {
		ClientResponse response = client.resource(FIND_ALL_URL)
				.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(FXUSER_LIST_TYPE);
	}

	@Override
	public FXUser findByUserName(final String username) {
		ClientResponse response = client
				.resource(FIND_BY_USERNAME_URL +"/"+ username)
				.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(FXUSER_TYPE);
	}
}
