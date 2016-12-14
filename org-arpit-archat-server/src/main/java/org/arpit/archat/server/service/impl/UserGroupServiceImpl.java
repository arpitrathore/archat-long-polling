/**
 * 
 */
package org.arpit.archat.server.service.impl;

import java.util.List;

import org.arpit.archat.server.dao.UserGroupDAO;
import org.arpit.archat.server.domain.UserGroup;
import org.arpit.archat.server.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Arpit.Rathore
 *
 */
@Transactional
@Service
public class UserGroupServiceImpl implements UserGroupService{
	
	@Autowired
	private UserGroupDAO userGroupDAO;
	
	public UserGroup create(final UserGroup userGroup) {
		return userGroupDAO.create(userGroup);
	}

	public List<UserGroup> findAll() {
		return userGroupDAO.findAll();
	}

}
