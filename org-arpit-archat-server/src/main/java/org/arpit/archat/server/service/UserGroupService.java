/**
 * 
 */
package org.arpit.archat.server.service;

import java.util.List;

import org.arpit.archat.server.domain.UserGroup;

/**
 * @author Arpit.Rathore
 *
 */
public interface UserGroupService {

	public UserGroup create(final UserGroup userGroup);

	public List<UserGroup> findAll();
}
