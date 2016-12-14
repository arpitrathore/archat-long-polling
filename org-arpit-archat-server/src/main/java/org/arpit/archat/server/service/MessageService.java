/**
 * 
 */
package org.arpit.archat.server.service;

import java.util.Date;
import java.util.List;

import org.arpit.archat.server.domain.Message;

/**
 * @author arpit.rathore
 *
 */
public interface MessageService {

	public Message create(Message message);
	
	List<Message> findBySenderAndReceiver(Long senderId, Long receiver);

	public List<Message> findByGroup(Long groupId, Date date);
}
