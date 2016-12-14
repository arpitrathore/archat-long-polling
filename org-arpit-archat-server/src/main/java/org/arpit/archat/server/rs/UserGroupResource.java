/**
 * 
 */
package org.arpit.archat.server.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.arpit.archat.server.domain.UserGroup;
import org.arpit.archat.server.dto.WSUserGroup;
import org.arpit.archat.server.service.UserGroupService;
import org.arpit.archat.server.service.UserService;
import org.arpit.archat.server.utility.DomainMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arpit.Rathore
 *
 */
@Path("userGroups")
@Component
public class UserGroupResource {

	@Autowired
	private UserGroupService userGroupService;
	
	@Autowired
	private UserService userService;
	
	@Path("/createUserGroup")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public WSUserGroup createUserGroup(final WSUserGroup wsUserGroup) {
		System.out.println("Inside UserGroupResource : createUserGroup");
		UserGroup mapToUserGroup = DomainMapperUtility.mapToUserGroup(wsUserGroup);
		return DomainMapperUtility.mapToWSUserGroup(userGroupService.create(mapToUserGroup));
	}
	
	@Path("/findAll")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<WSUserGroup> findAll() {
		System.out.println("Inside UserGroupResource : findAll");
		final List<WSUserGroup> wsUserGroups = new ArrayList<WSUserGroup>();
		final List<UserGroup> userGroups = userGroupService.findAll();
		if (userGroups != null) {
			for (UserGroup user : userGroups) {
				wsUserGroups.add(DomainMapperUtility.mapToWSUserGroup(user));
			}
			return wsUserGroups;
		}
		return null;
	}
}
