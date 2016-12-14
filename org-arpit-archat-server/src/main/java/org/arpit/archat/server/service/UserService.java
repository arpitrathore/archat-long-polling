/**
 * 
 */
package org.arpit.archat.server.service;

import java.util.List;

import org.arpit.archat.server.domain.User;

/**
 * @author Arpit.Rathore
 *
 */
public interface UserService {

	public User create(User user);

	public User findById(Long id);

	public List<User> findAll();

	public User findByusername(String username);
}
