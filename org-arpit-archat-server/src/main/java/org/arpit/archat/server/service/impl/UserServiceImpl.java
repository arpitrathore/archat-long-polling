/**
 * 
 */
package org.arpit.archat.server.service.impl;

import java.util.List;

import org.arpit.archat.server.dao.UserDAO;
import org.arpit.archat.server.domain.User;
import org.arpit.archat.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Arpit.Rathore
 *
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public User create(User user) {
		return userDAO.create(user);
	}

	public User findById(Long id) {
		return userDAO.findById(id);
	}

	public List<User> findAll() {
		return userDAO.findAll();
	}

	public User findByusername(String username) {
		return userDAO.findByusername(username);
	}
}
