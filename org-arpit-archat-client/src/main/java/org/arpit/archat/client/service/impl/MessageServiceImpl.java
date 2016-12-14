/**
 * 
 */
package org.arpit.archat.client.service.impl;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.arpit.archat.client.dto.FXMessage;
import org.arpit.archat.client.service.MessageService;
import org.arpit.archat.common.utility.DateTimeUtility;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Arpit.Rathore
 *
 */
public class MessageServiceImpl extends GenericServiceImpl implements MessageService {

	private final String CREATE_MESSAGE_URL = GENERIC_URL + "/messages/createMessage";
	private final String FINDBY_SENDER_RECEIVER_URL = GENERIC_URL + "/messages/findBySenderAndReceiver";
	private final String FINDBY_GROUP_URL = GENERIC_URL + "/messages/findByGroup";
	private final GenericType<FXMessage> FXMESSAGE_TYPE = new GenericType<FXMessage>() {
	};
	private final GenericType<List<FXMessage>> FXMESSAGE_LIST_TYPE = new GenericType<List<FXMessage>>() {
	};

	@Override
	public void createMessage(final FXMessage message) {
		ClientResponse response = client.resource(CREATE_MESSAGE_URL).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, message);
		System.out.println("Message sent : " + response.getEntity(FXMESSAGE_TYPE).getText());
	}

	@Override
	public List<FXMessage> findBysenderAndReceiver(final Long senderId, final Long receiverId) {
		ClientResponse response = client.resource(FINDBY_SENDER_RECEIVER_URL + "/" + senderId + "/" + receiverId)
				.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(FXMESSAGE_LIST_TYPE);
	}

	@Override
	public List<FXMessage> findByGroup(Long groupId, Date date) {
		WebResource resource = client.resource(FINDBY_GROUP_URL + "/" + groupId);
		if (date != null) {
			resource = resource.queryParam("date", DateTimeUtility.convertDateTimeToString(date));
		}
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(FXMESSAGE_LIST_TYPE);
	}
}
