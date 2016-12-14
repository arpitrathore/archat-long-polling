/**
 * 
 */
package org.arpit.archat.client.service.impl;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.arpit.archat.client.dto.FXUserGroup;
import org.arpit.archat.client.service.UserGroupService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

/**
 * @author Arpit.Rathore
 *
 */
public class UserGroupServiceImpl extends GenericServiceImpl implements
		UserGroupService {

	private final String CREATE_MESSAGE_URL = GENERIC_URL
			+ "/userGroups/createUserGroup";
	private final String FIND_ALL_URL = GENERIC_URL + "/userGroups/findAll";
	
	private final GenericType<FXUserGroup> FXUSERGROUP_TYPE = new GenericType<FXUserGroup>() {
	};
	private final GenericType<List<FXUserGroup>> FXUSERGROUP_LIST_TYPE = new GenericType<List<FXUserGroup>>() {
	};

	@Override
	public FXUserGroup createUserGroup(FXUserGroup userGroup) {
		ClientResponse response = client.resource(CREATE_MESSAGE_URL)
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, userGroup);
		return response.getEntity(FXUSERGROUP_TYPE);
	}

	@Override
	public List<FXUserGroup> findAll() {
		ClientResponse response = client.resource(FIND_ALL_URL)
				.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(FXUSERGROUP_LIST_TYPE);
	}

}
