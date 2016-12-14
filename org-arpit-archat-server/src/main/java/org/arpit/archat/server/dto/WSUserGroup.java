/**
 * 
 */
package org.arpit.archat.server.dto;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.arpit.archat.common.dto.IUserGroup;

/**
 * @author Arpit.Rathore
 *
 */
@XmlRootElement(name = "userGroup")
public class WSUserGroup extends WSAbstractEntity implements IUserGroup{

	private String name;
	private Set<WSUser> users;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<WSUser> getUsers() {
		return users;
	}
	public void setUsers(Set<WSUser> users) {
		this.users = users;
	}
}
