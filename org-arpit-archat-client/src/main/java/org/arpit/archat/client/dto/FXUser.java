/**
 * 
 */
package org.arpit.archat.client.dto;

import java.util.Date;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlRootElement;

import org.arpit.archat.common.dto.IUser;

/**
 * @author Arpit.Rathore
 * 
 */
@XmlRootElement(name = "user")
public class FXUser extends FXAbstractEntity implements IUser{

	private StringProperty firstName = new SimpleStringProperty();
	private StringProperty lastName = new SimpleStringProperty();
	private StringProperty userName = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	private ObjectProperty<Date> birthDate = new SimpleObjectProperty<>();
	private StringProperty gender = new SimpleStringProperty();
	private StringProperty mobile = new SimpleStringProperty();
	private StringProperty currentEmail = new SimpleStringProperty();
	private StringProperty country = new SimpleStringProperty();

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public String getUserName() {
		return userName.get();
	}

	public void setUserName(String userName) {
		this.userName.set(userName);
	}

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	public Date getBirthDate() {
		return birthDate.get();
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate.set(birthDate);
	}

	public String getGender() {
		return gender.get();
	}

	public void setGender(String gender) {
		this.gender.set(gender);
	}

	public String getMobile() {
		return mobile.get();
	}

	public void setMobile(String mobile) {
		this.mobile.set(mobile);
	}

	public String getCurrentEmail() {
		return currentEmail.get();
	}

	public void setCurrentEmail(String currentEmail) {
		this.currentEmail.set(currentEmail);
	}

	public String getCountry() {
		return country.get();
	}

	public void setCountry(String country) {
		this.country.set(country);
	}

	public StringProperty userNameProperty() {
		return this.userName;
	}

	public StringProperty passwordProperty() {
		return this.password;
	}

	public StringProperty firstNameProperty() {
		return this.firstName;
	}

	public StringProperty lastNameProperty() {
		return this.lastName;
	}

	public ObjectProperty<Date> birthDateProperty() {
		return this.birthDate;
	}

	public StringProperty genderProperty() {
		return this.gender;
	}

	public StringProperty mobileProperty() {
		return this.mobile;
	}

	public StringProperty currentEmailProperty() {
		return this.currentEmail;
	}

	public StringProperty countryProperty() {
		return this.country;
	}

	@Override
	public List<? extends IUser> getFriends() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){
		return getFirstName() + " " + getLastName();
	}
}
