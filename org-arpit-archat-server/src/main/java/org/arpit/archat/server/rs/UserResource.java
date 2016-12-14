/**
 * 
 */
package org.arpit.archat.server.rs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.arpit.archat.server.domain.User;
import org.arpit.archat.server.dto.WSUser;
import org.arpit.archat.server.service.UserService;
import org.arpit.archat.server.utility.DomainMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arpit.Rathore
 * 
 */
@Path("users")
@Component
public class UserResource {

	@Autowired
	private UserService userService;

	@Path("/createUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public WSUser createUser(WSUser wsuser) {
		System.out.println("Inside UserResource : createUser");
		final User user = DomainMapperUtility.mapToUser(wsuser);
		if(wsuser.getFriends() != null) {
			Set<User> friends = new HashSet<User>();
			for (WSUser friend : wsuser.getFriends()) {
				friends.add(DomainMapperUtility.mapToUser(friend));
			}
			user.setFriends(friends);
		}
		user.setLastModificationDate(new Date());
		User createdUser = userService.create(user);
		return DomainMapperUtility.mapToWSUser(createdUser);
	}

	@Path("/findById/{userId}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public WSUser findById(@PathParam("userId") final Long id) {
		System.out.println("Inside UserResource : findById");
		return DomainMapperUtility.mapToWSUser(userService.findById(id));
	}
	
	@Path("/findByUsername/{username}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public WSUser findByUsername(@PathParam("username") final String username) {
		System.out.println("Inside UserResource : findByUsername");
		User findByusername = userService.findByusername(username);
		return DomainMapperUtility.mapToWSUser(findByusername);
	}
	
	@Path("/findAll")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<WSUser> findAll() {
		System.out.println("Inside UserResource : findAll");
		final List<WSUser> wsUsers = new ArrayList<WSUser>();
		final List<User> users = userService.findAll();
		if (users != null) {
			for (User user : users) {
				wsUsers.add(DomainMapperUtility.mapToWSUser(user));
			}
			return wsUsers;
		}
		return null;
	}

	
	
	

}
