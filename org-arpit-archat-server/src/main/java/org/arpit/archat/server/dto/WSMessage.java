/**
 * 
 */
package org.arpit.archat.server.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.arpit.archat.common.dto.IMessage;

/**
 * @author arpit.rathore
 *
 */
@XmlRootElement(name = "message")
public class WSMessage extends WSAbstractEntity implements IMessage{
	
	private String text;
	private WSUser sender;
	private WSUser receiver;
	private WSUserGroup userGroup;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public WSUser getSender() {
		return sender;
	}

	public void setSender(WSUser sender) {
		this.sender = sender;
	}

	public WSUser getReceiver() {
		return receiver;
	}

	public void setReceiver(WSUser receiver) {
		this.receiver = receiver;
	}

	public WSUserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(WSUserGroup userGroup) {
		this.userGroup = userGroup;
	}
}
