/**
 * 
 */
package org.arpit.archat.server.service.impl;

import java.util.Date;
import java.util.List;

import org.arpit.archat.server.dao.MessageDAO;
import org.arpit.archat.server.domain.Message;
import org.arpit.archat.server.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author arpit.rathore
 *
 */
@Transactional
@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageDAO messageDAO;

	public Message create(Message message) {
		return messageDAO.create(message);
	}

	public List<Message> findBySenderAndReceiver(Long senderId, Long receiver) {
		return messageDAO.findBySenderAndReceiver(senderId, receiver);
	}

	public List<Message> findByGroup(Long groupId, Date date) {
		return messageDAO.findByGroup(groupId, date);
	}
	
	
}
