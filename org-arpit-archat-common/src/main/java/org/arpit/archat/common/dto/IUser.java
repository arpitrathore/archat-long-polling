/**
 * 
 */
package org.arpit.archat.common.dto;

import java.util.Date;
import java.util.List;

/**
 * @author Arpit.Rathore
 *
 */
public interface IUser extends IAbstractEntity{

	public String getFirstName();

	public String getLastName();

	public String getUserName();

	public String getPassword();

	public Date getBirthDate();

	public String getGender();

	public String getMobile();

	public String getCurrentEmail();

	public String getCountry();
	
	public List<? extends IUser> getFriends();

}
