/**
 * 
 */
package org.arpit.archat.server.rs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.arpit.archat.common.utility.DateTimeUtility;
import org.arpit.archat.server.domain.Message;
import org.arpit.archat.server.dto.WSMessage;
import org.arpit.archat.server.service.MessageService;
import org.arpit.archat.server.utility.DomainMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arpit.rathore
 *
 */
@Path("messages")
@Component
public class MessageResource {

	@Autowired
	private MessageService messageService;

	@Path("/createMessage")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public WSMessage createMessage(WSMessage wsMessage) {
		System.out.println("Inside MessageResource : createMessage");
		return DomainMapperUtility.mapToWSMessage(messageService.create(DomainMapperUtility.mapToMessage(wsMessage)));
	}

	@Path("/findBySenderAndReceiver/{senderId}/{receiverId}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<WSMessage> findBySenderAndReceiver(@PathParam("senderId") final Long senderId,
			@PathParam("receiverId") final Long receiverId) {
		System.out.println("Inside MessageResource : findBySenderAndReceiver for senderId : " + senderId + " and receiverId : "
				+ receiverId);

		final List<WSMessage> wsMessages = new ArrayList<WSMessage>();
		final List<Message> messages = messageService.findBySenderAndReceiver(senderId, receiverId);
		if (messages != null) {
			for (Message message : messages) {
				wsMessages.add(DomainMapperUtility.mapToWSMessage(message));
			}
			return wsMessages;
		}
		return null;
	}

	@Path("/findByGroup/{groupId}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<WSMessage> findByGroup(@PathParam("groupId") final Long groupId, @QueryParam("date") final String date) {
		System.out.println("Inside MessageResource : findByGroup for groupId : " + groupId + " at :" + date);

		final List<WSMessage> wsMessages = new ArrayList<WSMessage>();
		final List<Message> messages = messageService.findByGroup(groupId, DateTimeUtility.convertStringToDateTime(date));
		if (messages != null) {
			for (Message message : messages) {
				wsMessages.add(DomainMapperUtility.mapToWSMessage(message));
			}
			return wsMessages;
		}
		return null;
	}
}
