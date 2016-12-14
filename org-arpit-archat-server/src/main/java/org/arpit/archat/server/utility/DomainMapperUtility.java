/**
 * 
 */
package org.arpit.archat.server.utility;

import java.util.HashSet;
import java.util.Set;

import org.arpit.archat.server.domain.AbstractEntity;
import org.arpit.archat.server.domain.Message;
import org.arpit.archat.server.domain.User;
import org.arpit.archat.server.domain.UserGroup;
import org.arpit.archat.server.dto.WSAbstractEntity;
import org.arpit.archat.server.dto.WSMessage;
import org.arpit.archat.server.dto.WSUser;
import org.arpit.archat.server.dto.WSUserGroup;

/**
 * Utility class for mapping domain model to/from WS entities
 * 
 * @author arpit.rathore
 *
 */
public abstract class DomainMapperUtility {

	/**
	 * Maps {@link WSUser} to {@link User}
	 * 
	 * @param wsuser
	 *            the {@link WSUser} to map from
	 * @return the mapped {@link User}
	 */
	public static User mapToUser(final WSUser wsuser) {
		final User user = new User();
		mapWSAbstractEntityToAbstractEntity(wsuser, user);
		user.setFirstName(wsuser.getFirstName());
		user.setLastName(wsuser.getLastName());
		user.setUserName(wsuser.getUserName());
		user.setBirthDate(wsuser.getBirthDate());
		user.setCountry(wsuser.getCountry());
		user.setCurrentEmail(wsuser.getCurrentEmail());
		user.setGender(wsuser.getGender());
		user.setMobile(wsuser.getMobile());
		user.setPassword(wsuser.getPassword());
		return user;
	}

	/**
	 * Maps {@link User} to {@link WSUser}
	 * 
	 * @param user
	 *            the {@link User} to map from
	 * @return the mapped {@link WSUser}
	 */
	public static WSUser mapToWSUser(final User user) {
		final WSUser wsUser = new WSUser();
		mapAbstractEntityToWSAbstractEntity(user, wsUser);
		wsUser.setFirstName(user.getFirstName());
		wsUser.setLastName(user.getLastName());
		wsUser.setUserName(user.getUserName());
		wsUser.setBirthDate(user.getBirthDate());
		wsUser.setCountry(user.getCountry());
		wsUser.setCurrentEmail(user.getCurrentEmail());
		wsUser.setGender(user.getGender());
		wsUser.setMobile(user.getMobile());
		wsUser.setPassword(user.getPassword());
		return wsUser;
	}

	/**
	 * Maps {@link WSMessage} to {@link Message}
	 * 
	 * @param wsuser
	 *            the {@link WSMessage} to map from
	 * @return the mapped {@link Message}
	 */
	public static Message mapToMessage(final WSMessage wsmessage) {
		final Message message = new Message();
		mapWSAbstractEntityToAbstractEntity(wsmessage, message);

		if (wsmessage.getReceiver() != null) {
			message.setReceiver(mapToUser(wsmessage.getReceiver()));
		}
		if (wsmessage.getSender() != null) {
			message.setSender(mapToUser(wsmessage.getSender()));
		}
		if (wsmessage.getUserGroup() != null) {
			message.setUserGroup(mapToUserGroup(wsmessage.getUserGroup()));
		}
		message.setText(wsmessage.getText());
		return message;
	}

	/**
	 * Maps {@link Message} to {@link WSMessage}
	 * 
	 * @param user
	 *            the {@link Message} to map from
	 * @return the mapped {@link WSMessage}
	 */
	public static WSMessage mapToWSMessage(final Message message) {
		final WSMessage wsMessage = new WSMessage();
		mapAbstractEntityToWSAbstractEntity(message, wsMessage);
		wsMessage.setSender(mapToWSUser(message.getSender()));

		if (message.getReceiver() != null) {
			wsMessage.setReceiver(mapToWSUser(message.getReceiver()));
		}

		if (message.getUserGroup() != null) {
			wsMessage.setUserGroup(mapToWSUserGroupWithoutUsers(message.getUserGroup()));
		}

		wsMessage.setText(message.getText());
		return wsMessage;
	}

	/**
	 * Maps {@link WSUserGroup} to {@link UserGroup}
	 * 
	 * @param wsuser
	 *            the {@link WSUserGroup} to map from
	 * @return the mapped {@link UserGroup}
	 */
	public static UserGroup mapToUserGroup(final WSUserGroup wsUserGroup) {
		final UserGroup userGroup = new UserGroup();
		mapWSAbstractEntityToAbstractEntity(wsUserGroup, userGroup);
		userGroup.setName(wsUserGroup.getName());

		final Set<WSUser> wsusers = wsUserGroup.getUsers();
		if (wsusers != null) {
			Set<User> users = new HashSet<User>(wsusers.size());
			for (WSUser user : wsusers) {
				users.add(mapToUser(user));
			}
			userGroup.setUsers(users);
		}

		return userGroup;
	}

	/**
	 * Maps {@link UserGroup} to {@link WSUserGroup}
	 * 
	 * @param user
	 *            the {@link UserGroup} to map from
	 * @return the mapped {@link WSUserGroup}
	 */
	public static WSUserGroup mapToWSUserGroupWithoutUsers(final UserGroup userGroup) {
		final WSUserGroup wsUserGroup = new WSUserGroup();
		mapAbstractEntityToWSAbstractEntity(userGroup, wsUserGroup);
		wsUserGroup.setName(userGroup.getName());
		return wsUserGroup;
	}

	/**
	 * Maps {@link UserGroup} to {@link WSUserGroup}
	 * 
	 * @param user
	 *            the {@link UserGroup} to map from
	 * @return the mapped {@link WSUserGroup}
	 */
	public static WSUserGroup mapToWSUserGroup(final UserGroup userGroup) {
		final WSUserGroup wsUserGroup = new WSUserGroup();
		mapAbstractEntityToWSAbstractEntity(userGroup, wsUserGroup);
		wsUserGroup.setName(userGroup.getName());

		final Set<User> users = userGroup.getUsers();
		if (users != null) {
			Set<WSUser> wsUsers = new HashSet<WSUser>(users.size());
			for (User user : users) {
				wsUsers.add(mapToWSUser(user));
			}
			wsUserGroup.setUsers(wsUsers);
		}

		return wsUserGroup;
	}

	private static void mapWSAbstractEntityToAbstractEntity(final WSAbstractEntity wsAbstractEntity, final AbstractEntity abstractEntity) {
		abstractEntity.setId(wsAbstractEntity.getId());
		abstractEntity.setLastModificationDate(wsAbstractEntity.getLastModificationDate());
	}

	private static void mapAbstractEntityToWSAbstractEntity(final AbstractEntity abstractEntity, final WSAbstractEntity wsAbstractEntity) {
		wsAbstractEntity.setId(abstractEntity.getId());
		wsAbstractEntity.setLastModificationDate(abstractEntity.getLastModificationDate());
	}
}
