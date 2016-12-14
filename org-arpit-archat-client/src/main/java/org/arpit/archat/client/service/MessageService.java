/**
 * 
 */
package org.arpit.archat.client.service;

import java.util.Date;
import java.util.List;

import org.arpit.archat.client.dto.FXMessage;

/**
 * @author Arpit.Rathore
 *
 */
public interface MessageService {

	void createMessage(FXMessage message);
	
	List<FXMessage> findBysenderAndReceiver(Long senderId, Long receiverId);

	List<FXMessage> findByGroup(Long groupId, Date date);
}
