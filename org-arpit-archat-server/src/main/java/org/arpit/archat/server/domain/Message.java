/**
 * 
 */
package org.arpit.archat.server.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author arpit.rathore
 *
 */
@Entity
public class Message extends AbstractEntity {

	private String text;

	@OneToOne
	private User sender;

	@OneToOne
	private User receiver;
	
	@OneToOne
	private UserGroup userGroup;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
}
