/**
 * 
 */
package org.arpit.archat.integration.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.arpit.archat.common.dto.IMessage;
import org.arpit.archat.common.dto.IUser;
import org.arpit.archat.common.dto.IUserGroup;

/**
 * @author arpit.rathore
 *
 */
@XmlRootElement(name = "message")
public class IntMessage implements IMessage{

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getLastModificationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public IUser getSender() {
		// TODO Auto-generated method stub
		return null;
	}

	public IUser getReceiver() {
		// TODO Auto-generated method stub
		return null;
	}

	public IUserGroup getUserGroup() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
