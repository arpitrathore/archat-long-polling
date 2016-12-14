/**
 * 
 */
package org.arpit.archat.common.dto;

import java.util.Set;

/**
 * @author Arpit.Rathore
 *
 */
public interface IUserGroup {
	public String getName();
	public Set<? extends IUser> getUsers();
}
