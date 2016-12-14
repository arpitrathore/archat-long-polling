/**
 * 
 */
package org.arpit.archat.common.dto;



/**
 * @author arpit.rathore
 *
 */
public interface IMessage extends IAbstractEntity{

	public String getText();

	public IUser getSender();

	public IUser getReceiver();
	
	public IUserGroup getUserGroup();

}
