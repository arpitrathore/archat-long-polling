/**
 * 
 */
package org.arpit.archat.server.dao.impl;

import java.util.Date;
import java.util.List;

import org.arpit.archat.server.dao.MessageDAO;
import org.arpit.archat.server.domain.Message;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author arpit.rathore
 *
 */
@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public Message create(Message message) {
		return (Message) getCurrentSession().merge(message);
	}

	@SuppressWarnings("unchecked")
	public List<Message> findBySenderAndReceiver(final Long senderId,
			final Long receiverId) {
		final Criteria criteria = getCurrentSession().createCriteria(
				Message.class);
		criteria.add(Restrictions.or(Restrictions.and(
				Restrictions.eq("sender.id", senderId),
				Restrictions.eq("receiver.id", receiverId)), Restrictions.and(
				Restrictions.eq("sender.id", receiverId),
				Restrictions.eq("receiver.id", senderId))));
		criteria.addOrder(Order.asc("lastModificationDate"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Message> findByGroup(Long groupId, Date date) {
		final Criteria criteria = getCurrentSession().createCriteria(
				Message.class);
		criteria.add(Restrictions.eq("userGroup.id", groupId));
		if(date != null){
			criteria.add(Restrictions.gt("lastModificationDate", date));
		}
		criteria.addOrder(Order.asc("lastModificationDate"));
		return criteria.list();
	}
}
