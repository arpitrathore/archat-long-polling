/**
 * 
 */
package org.arpit.archat.server.dao;

import java.util.Date;
import java.util.List;

import org.arpit.archat.server.domain.Message;

/**
 * @author arpit.rathore
 *
 */
public interface MessageDAO {

	Message create(Message message);
	
	List<Message> findBySenderAndReceiver(Long senderId, Long receiver);

	List<Message> findByGroup(Long groupId, Date date);

}
