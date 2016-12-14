/**
 * 
 */
package org.arpit.archat.client.view;

import org.arpit.archat.client.HasListeners;
import org.arpit.archat.client.dto.FXUser;

/**
 * @author arpit
 *
 */
public interface RegistrationView extends View, HasListeners<RegistrationViewListener> {

	void setModel(FXUser user);
}
