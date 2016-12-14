/**
 * 
 */
package org.arpit.archat.client.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.arpit.archat.common.dto.IMessage;

/**
 * @author Arpit.Rathore
 *
 */
@XmlRootElement(name = "message")
public class FXMessage extends FXAbstractEntity implements IMessage{
	
	private String text;
	private FXUser sender;
	private FXUser receiver;
	private FXUserGroup userGroup;


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public FXUser getSender() {
		return sender;
	}

	public void setSender(FXUser sender) {
		this.sender = sender;
	}

	public FXUser getReceiver() {
		return receiver;
	}

	public void setReceiver(FXUser receiver) {
		this.receiver = receiver;
	}

	public FXUserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(FXUserGroup userGroup) {
		this.userGroup = userGroup;
	}
}
