/**
 * 
 */
package org.arpit.archat.client.view;

import org.arpit.archat.client.dto.FXUser;

/**
 * @author arpit
 *
 */
public interface LoginView extends View {

	void setModel(FXUser model);
	
	void addListener(LoginViewListener listener);
	
	void removeListener(LoginViewListener listener);

}
