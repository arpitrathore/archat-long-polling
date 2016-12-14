package org.arpit.archat.integration.domain;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.arpit.archat.common.dto.IUser;

/**
 * @author Arpit.Rathore
 *
 */
@XmlRootElement(name="user")
public class IntUser implements IUser {

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getLastModificationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getBirthDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMobile() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCurrentEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<? extends IUser> getFriends() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
