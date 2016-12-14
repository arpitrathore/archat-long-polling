/**
 * 
 */
package org.arpit.archat.client.service;

import java.util.List;

import org.arpit.archat.client.dto.FXUser;

/**
 * @author Arpit.Rathore
 *
 */
public interface UserService {

	List<FXUser> findAll();
	
	FXUser findByUserName(String username);
}
