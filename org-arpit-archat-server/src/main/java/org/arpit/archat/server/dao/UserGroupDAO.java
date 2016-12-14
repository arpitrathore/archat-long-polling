/**
 * 
 */
package org.arpit.archat.server.dao;

import java.util.List;

import org.arpit.archat.server.domain.UserGroup;

/**
 * @author Arpit.Rathore
 *
 */
public interface UserGroupDAO {

	public UserGroup create(final UserGroup userGroup);

	public List<UserGroup> findAll();
}
