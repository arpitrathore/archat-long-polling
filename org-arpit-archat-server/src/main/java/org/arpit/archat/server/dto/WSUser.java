/**
 * 
 */
package org.arpit.archat.server.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.arpit.archat.common.dto.IUser;

/**
 * @author Arpit.Rathore
 *
 */
@XmlRootElement(name = "user")
public class WSUser extends WSAbstractEntity implements IUser{

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Date birthDate;
	private String gender;
	private String mobile;
	private String currentEmail;
	private String country;
	private List<WSUser> friends;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCurrentEmail() {
		return currentEmail;
	}
	public void setCurrentEmail(String currentEmail) {
		this.currentEmail = currentEmail;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<WSUser> getFriends() {
		return this.friends;
	}
	public void setFriends(List<WSUser> friends) {
		this.friends = friends;
	}
	

	
}
