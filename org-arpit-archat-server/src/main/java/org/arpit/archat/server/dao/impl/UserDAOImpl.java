/**
 * 
 */
package org.arpit.archat.server.dao.impl;

import java.util.List;

import org.arpit.archat.server.dao.UserDAO;
import org.arpit.archat.server.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Arpit.Rathore
 *
 */
@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		Session session =  sessionFactory.getCurrentSession();
		return session;
	}

	public User create(User user) {
		return (User) getCurrentSession().merge(user);
	}

	public User findById(Long id) {
		final Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.idEq(id));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		final Criteria criteria = getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

	public User findByusername(String username) {
		final Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", username));
		return (User) criteria.uniqueResult();
	}
}
