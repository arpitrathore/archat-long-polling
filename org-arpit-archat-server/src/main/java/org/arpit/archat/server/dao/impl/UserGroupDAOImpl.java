/**
 * 
 */
package org.arpit.archat.server.dao.impl;

import java.util.List;

import org.arpit.archat.server.dao.UserGroupDAO;
import org.arpit.archat.server.domain.UserGroup;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Arpit.Rathore
 *
 */
@Repository
public class UserGroupDAOImpl implements UserGroupDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		Session session =  sessionFactory.getCurrentSession();
		return session;
	}

	public UserGroup create(final UserGroup userGroup) {
		return (UserGroup) getCurrentSession().merge(userGroup);
	}

	@SuppressWarnings("unchecked")
	public List<UserGroup> findAll() {
		final Criteria criteria = getCurrentSession().createCriteria(UserGroup.class);
		criteria.createCriteria("users", JoinType.LEFT_OUTER_JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
}
