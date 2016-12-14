/**
 * 
 */
package org.arpit.archat.client.service;

import java.util.List;

import org.arpit.archat.client.dto.FXUserGroup;

/**
 * @author Arpit.Rathore
 *
 */
public interface UserGroupService {

	FXUserGroup createUserGroup(FXUserGroup userGroup);

	List<FXUserGroup> findAll();
}
